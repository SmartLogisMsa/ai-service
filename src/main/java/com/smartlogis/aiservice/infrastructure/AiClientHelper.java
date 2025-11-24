package com.smartlogis.aiservice.infrastructure;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AiClientHelper {

	private final ChatClient vertexAiGeminiClient;

	public ChatClient get(AiModel model) {
		return switch (model) {
			case VERTEX_AI_GEMINI -> vertexAiGeminiClient;
		};
	}
}
