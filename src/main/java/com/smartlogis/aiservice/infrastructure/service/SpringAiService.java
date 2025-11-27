package com.smartlogis.aiservice.infrastructure.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.template.st.StTemplateRenderer;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.smartlogis.aiservice.application.dto.AiCreateResult;
import com.smartlogis.aiservice.application.service.AiGenerateService;
import com.smartlogis.aiservice.infrastructure.SpringAiHelper;
import com.smartlogis.aiservice.infrastructure.SpringAiModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpringAiService implements AiGenerateService {

	private final SpringAiHelper clientHelper;

	@Override
	public AiCreateResult generate(String prompt, Map<String, Object> params, String model) {
		ChatClient client = clientHelper.get(SpringAiModel.fromString(model));

		String fullPrompt = PromptTemplate.builder()
			.renderer(StTemplateRenderer.builder().startDelimiterToken('{').endDelimiterToken('}').build())
			.template(prompt)
			.build()
			.render(params);

		try {
			long start = System.currentTimeMillis();

			String response = client.prompt()
				.user(fullPrompt)
				.call()
				.content();

			Long latency = System.currentTimeMillis() - start;

			return AiCreateResult.from(prompt, fullPrompt, response, null, "SUCCESS", model, latency);
		} catch (Exception e) {
			String errorMessage = e.getMessage();

			return AiCreateResult.from(prompt, fullPrompt, null, errorMessage, "FAIL", model, null);
		}
	}

	@Override
	public AiCreateResult generate(Resource prompt, Map<String, Object> params, String model) {
		try {
			String text = new String(prompt.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
			return generate(text, params, model);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
