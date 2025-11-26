package com.smartlogis.aiservice.presentation.dto;

import java.time.LocalDateTime;

import com.smartlogis.aiservice.domain.AiLog;

public record AiLogResponse(
	Long id,
	String type,
	String prompt,
	String fullPrompt,
	String response,
	String errorMessage,
	String status,
	String model,
	Long latency,
	LocalDateTime createdAt,
	String createdBy
) {
	public static AiLogResponse from(AiLog entity) {
		return new AiLogResponse(
			entity.getId(),
			entity.getType().getValue(),
			entity.getPrompt(),
			entity.getFullPrompt(),
			entity.getResponse(),
			entity.getErrorMessage(),
			entity.getStatus().getValue(),
			entity.getModel(),
			entity.getLatency(),
			entity.getCreatedAt(),
			entity.getCreatedBy()
		);
	}
}
