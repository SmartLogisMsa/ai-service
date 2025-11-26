package com.smartlogis.aiservice.application.dto;

import com.smartlogis.aiservice.domain.AiStatus;

public record AiCreateResult(
	String prompt,
	String fullPrompt,
	String response,
	String errorMessage,
	AiStatus status,
	String model,
	Long latency
) {
	public static AiCreateResult from(
		String prompt,
		String fullPrompt,
		String response,
		String errorMessage,
		String status,
		String model,
		Long latency
	) {
		return new AiCreateResult(
			prompt,
			fullPrompt,
			response,
			errorMessage,
			AiStatus.fromString(status),
			model,
			latency
		);
	}
}
