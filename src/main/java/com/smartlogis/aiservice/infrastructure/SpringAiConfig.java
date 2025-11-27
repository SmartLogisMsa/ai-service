package com.smartlogis.aiservice.infrastructure;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAiConfig {

	@Bean
	public ChatClient vertexAiGeminiClient(VertexAiGeminiChatModel model) {
		return ChatClient.create(model);
	}
}
