package com.smartlogis.aiservice.application.dto;

import com.smartlogis.aiservice.domain.AiStatus;

public record AiResponse (
	String prompt,
	String response,
	String errorMessage,
	AiStatus status,
	String model,
	Long latency
) {
	public static AiResponse from(
		String prompt,
		String response,
		String errorMessage,
		String status,
		String model,
		Long latency
	) {
		return new AiResponse(
			prompt,
			response,
			errorMessage,
			AiStatus.fromString(status),
			model,
			latency
		);
	}
}
