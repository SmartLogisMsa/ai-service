package com.smartlogis.aiservice.domain.exception;

import org.springframework.http.HttpStatus;

import com.smartlogis.common.exception.MessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiLogMessageCode implements MessageCode {
	INVALID_REQUEST_TYPE("AI.INVALID_REQUEST_TYPE", HttpStatus.BAD_REQUEST),
	UPDATE_NOT_ALLOWED("AI.UPDATE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	DELETE_NOT_ALLOWED("AI.DELETE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	LOG_NOT_FOUND("AI.LOG_NOT_FOUND", HttpStatus.NOT_FOUND),
	;

    private final String code;
    private final HttpStatus status;
}
