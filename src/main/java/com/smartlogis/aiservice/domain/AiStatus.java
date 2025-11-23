package com.smartlogis.aiservice.domain;

import com.smartlogis.aiservice.domain.exception.AiException;
import com.smartlogis.aiservice.domain.exception.AiMessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiStatus {
	SUCCESS("SUCCESS"),
	FAIL("FAIL");
	;

	private final String value;

	public static AiStatus fromString(String str) {
		try {
			return AiStatus.valueOf(str.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new AiException(AiMessageCode.INVALID_REQUEST_TYPE, e);
		}
	}
}
