package com.smartlogis.aiservice.domain.exception;

import org.springframework.http.HttpStatus;

import com.smartlogis.common.exception.MessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiLogMessageCode implements MessageCode {
	INVALID_REQUEST_TYPE("AILOG.INVALID_REQUEST_TYPE", HttpStatus.BAD_REQUEST),
	UPDATE_NOT_ALLOWED("AILOG.UPDATE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	DELETE_NOT_ALLOWED("AILOG.DELETE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	LOG_NOT_FOUND("AILOG.LOG_NOT_FOUND", HttpStatus.NOT_FOUND),
	;

    private final String code;
    private final HttpStatus status;
}
