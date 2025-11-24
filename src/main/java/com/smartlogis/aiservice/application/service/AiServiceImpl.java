package com.smartlogis.aiservice.application.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartlogis.aiservice.application.dto.AiCreateResult;
import com.smartlogis.aiservice.application.dto.DeliveryDeadlineCommand;
import com.smartlogis.aiservice.application.exception.AiException;
import com.smartlogis.aiservice.application.exception.AiMessageCode;
import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.domain.service.AiLogCreateService;
import com.smartlogis.aiservice.presentation.dto.AiCreateResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {

	private final ObjectMapper mapper;

	private final AiCreateService aiCreateService;
	private final AiLogCreateService aiLogCreateService;

	@Override
	public AiCreateResponse deliveryDeadlineMessage(String model, DeliveryDeadlineCommand command) {
		try {
			Resource resource = new ClassPathResource("prompt/DeliveryDeadlineMessage.txt");
			String prompt = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

			Map<String, Object> params = mapper.convertValue(command, Map.class);

			AiLog aiLog = aiLogCreateService.create(AiType.ORDER_SUMMARY, prompt, model);
			AiCreateResult result = aiCreateService.create(resource, params, model);

			if (result.success()) {
				aiLog.success(result.fullPrompt(), result.response(), result.latency());
				return AiCreateResponse.from(result);
			}

			aiLog.fail(result.fullPrompt(), result.errorMessage());
			throw new AiException(AiMessageCode.INTERNAL_SERVER_ERROR, result.errorMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
