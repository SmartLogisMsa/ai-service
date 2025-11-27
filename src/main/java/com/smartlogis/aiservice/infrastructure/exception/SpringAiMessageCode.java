package com.smartlogis.aiservice.infrastructure.exception;

import org.springframework.http.HttpStatus;

import com.smartlogis.common.exception.MessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpringAiMessageCode implements MessageCode {
	INVALID_MODEL("SPRING_AI.INVALID_MODEL", HttpStatus.BAD_REQUEST),
	;

    private final String code;
    private final HttpStatus status;
}
