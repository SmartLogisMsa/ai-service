package com.smartlogis.aiservice.infrastructure;

import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.infrastructure.exception.SpringAiMessageCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SpringAiModel {
	VERTEX_AI_GEMINI("vertex_ai_gemini");

	private final String value;

	public static SpringAiModel fromString(String str) {
		try {
			return SpringAiModel.valueOf(str.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new AiLogException(SpringAiMessageCode.INVALID_MODEL, e);
		}
	}
}
