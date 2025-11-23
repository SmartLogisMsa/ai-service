package com.smartlogis.aiservice.domain;

import com.smartlogis.aiservice.domain.exception.AiException;
import com.smartlogis.aiservice.domain.exception.AiMessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiType {
	GENERATE_ORDER_SUMMARY("generate_order_summary");

	private final String value;

	public static AiType fromString(String str) {
		try {
			return AiType.valueOf(str.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new AiException(AiMessageCode.INVALID_REQUEST_TYPE, e);
		}
	}
}
