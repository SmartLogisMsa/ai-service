package com.smartlogis.aiservice.application.dto;

import com.smartlogis.aiservice.domain.AiStatus;
import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.domain.dto.AiLogSearch;
import com.smartlogis.aiservice.presentation.dto.AiLogSearchRequest;

public record AiLogSearchCommand (
	AiType aiType,
	AiStatus aiStatus,
	String model
) {
	public static AiLogSearchCommand of(AiLogSearchRequest request) {
		return new AiLogSearchCommand(
			AiType.fromString(request.getAiType()),
			AiStatus.fromString(request.getAiStatus()),
			request.getModel()
		);
	}

	public AiLogSearch toAiLogSearch() {
		return new AiLogSearch(aiType, aiStatus, model);
	}
}
