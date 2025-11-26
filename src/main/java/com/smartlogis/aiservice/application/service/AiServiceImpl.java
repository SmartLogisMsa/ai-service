package com.smartlogis.aiservice.application.service;

import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.smartlogis.aiservice.application.dto.AiCreateResult;
import com.smartlogis.aiservice.application.dto.AiLogMapper;
import com.smartlogis.aiservice.application.dto.AiLogSearchCommand;
import com.smartlogis.aiservice.application.dto.DeliveryDeadlineCommand;
import com.smartlogis.aiservice.application.dto.PageCommand;
import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.domain.service.AiLogCreateService;
import com.smartlogis.aiservice.domain.service.AiLogQueryService;
import com.smartlogis.aiservice.presentation.dto.AiCreateResponse;
import com.smartlogis.aiservice.presentation.dto.AiLogResponse;
import com.smartlogis.common.presentation.dto.PageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {

	private final AiGenerateService aiGenerateService;
	private final AiLogCreateService aiLogCreateService;
	private final AiLogQueryService aiLogQueryService;

	@Override
	public AiCreateResponse deliveryDeadlineMessage(String model, DeliveryDeadlineCommand command) {
		Resource resource = new ClassPathResource("prompt/DeliveryDeadlineMessage.txt");
		Map<String, Object> params = command.getParams();

		AiCreateResult result = aiGenerateService.generate(resource, params, model);
		aiLogCreateService.create(AiLogMapper.toAiLogCreate(AiType.DELIVERY_DEADLINE, result));

		return AiCreateResponse.from(result);
	}

	@Override
	public AiLogResponse getAiLogById(Long id) {
		AiLog aiLog = aiLogQueryService.getAiLogById(id);
		return AiLogResponse.from(aiLog);
	}

	@Override
	public PageResponse<AiLogResponse> getAiLogs(AiLogSearchCommand search, PageCommand page) {
		Page<AiLog> aiLogs = aiLogQueryService.getAiLogs(search.toAiLogSearch(), page.getPageable());
		return PageResponse.from(aiLogs, AiLogResponse.class);
	}
}
