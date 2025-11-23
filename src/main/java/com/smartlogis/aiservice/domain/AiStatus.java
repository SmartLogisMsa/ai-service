package com.smartlogis.aiservice.domain;

import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.domain.exception.AiLogMessageCode;

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
			throw new AiLogException(AiLogMessageCode.INVALID_REQUEST_TYPE, e);
		}
	}
}
