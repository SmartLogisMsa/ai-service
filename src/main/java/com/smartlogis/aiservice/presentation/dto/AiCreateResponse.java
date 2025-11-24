package com.smartlogis.aiservice.presentation.dto;

import com.smartlogis.aiservice.application.dto.AiCreateResult;

public record AiCreateResponse(
	String prompt,
	String response,
	String model,
	String status,
	String errorMessage
) {
	public static AiCreateResponse from(AiCreateResult result) {
		return new AiCreateResponse(
			result.prompt(),
			result.response(),
			result.model(),
			result.status().getValue(),
			result.errorMessage()
		);
	}
}
