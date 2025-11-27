package com.smartlogis.aiservice.application.dto;

import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.domain.dto.AiLogCreate;

public class AiLogMapper {

	public static AiLogCreate toAiLogCreate(AiType type, AiCreateResult result) {
		return new AiLogCreate(
			type,
			result.prompt(),
			result.fullPrompt(),
			result.response(),
			result.errorMessage(),
			result.status(),
			result.model(),
			result.latency()
		);
	}
}
