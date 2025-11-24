package com.smartlogis.aiservice.application.exception;

import org.springframework.http.HttpStatus;

import com.smartlogis.common.exception.MessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiMessageCode implements MessageCode {
	INTERNAL_SERVER_ERROR("AI.INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
	;

    private final String code;
    private final HttpStatus status;
}
