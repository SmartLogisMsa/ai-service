package com.smartlogis.aiservice.domain.exception;

import org.springframework.http.HttpStatus;

import com.smartlogis.common.exception.MessageCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiMessageCode implements MessageCode {
	INVALID_REQUEST_TYPE("AI.INVALID_REQUEST_TYPE", HttpStatus.BAD_REQUEST),
	UPDATE_NOT_ALLOWED("AI.UPDATE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	DELETE_NOT_ALLOWED("AI.DELETE_NOT_ALLOWED", HttpStatus.METHOD_NOT_ALLOWED),
	;

    private final String code;
    private final HttpStatus status;
}
