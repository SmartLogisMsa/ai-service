package com.smartlogis.aiservice.domain;

import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.domain.exception.AiLogMessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiType {
	DELIVERY_DEADLINE("delivery_deadline"),;

	private final String value;

	public static AiType fromString(String str) {
		try {
			return AiType.valueOf(str.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new AiLogException(AiLogMessageCode.INVALID_REQUEST_TYPE, e);
		}
	}
}
