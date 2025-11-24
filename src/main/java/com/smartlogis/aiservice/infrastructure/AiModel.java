package com.smartlogis.aiservice.infrastructure;

import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.infrastructure.exception.AiMessageCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AiModel {
	VERTEX_AI_GEMINI("vertex_ai_gemini");

	private final String value;

	public static AiModel fromString(String str) {
		try {
			return AiModel.valueOf(str.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new AiLogException(AiMessageCode.INVALID_MODEL, e);
		}
	}
}
