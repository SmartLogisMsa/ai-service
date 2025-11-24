package com.smartlogis.aiservice.application.dto;

import com.smartlogis.aiservice.domain.AiStatus;

public record AiResult(
	String prompt,
	String response,
	String errorMessage,
	AiStatus status,
	String model,
	Long latency
) {
	public static AiResult from(
		String prompt,
		String response,
		String errorMessage,
		String status,
		String model,
		Long latency
	) {
		return new AiResult(
			prompt,
			response,
			errorMessage,
			AiStatus.fromString(status),
			model,
			latency
		);
	}
}
