package com.smartlogis.aiservice.infrastructure.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.smartlogis.aiservice.application.dto.AiResponse;
import com.smartlogis.aiservice.infrastructure.AiClientHelper;
import com.smartlogis.aiservice.infrastructure.AiModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiCreateService {

	private final AiClientHelper clientHelper;

	public AiResponse generate(String prompt, Map<String, Object> params, String model) {
		ChatClient client = clientHelper.get(AiModel.fromString(model));

		try {
			long start = System.currentTimeMillis();

			String response = client.prompt()
				.user(s -> {
					s.text(prompt);
					params.forEach(s::param);
				})
				.call()
				.content();

			Long latency = System.currentTimeMillis() - start;

			return AiResponse.from(prompt, response, null, "SUCCESS", model, latency);
		} catch (Exception e) {
			String errorMessage = e.getMessage();

			return AiResponse.from(prompt, null, errorMessage, "FAIL", model, null);
		}
	}

	public AiResponse generate(Resource prompt, Map<String, Object> params, String model) {
		try {
			String text = new String(prompt.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
			return generate(text, params, model);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
