package com.smartlogis.aiservice.infrastructure.exception;

import com.smartlogis.common.exception.AbstractException;
import com.smartlogis.common.exception.MessageCode;

public class AiException extends AbstractException {
	public AiException(MessageCode messageCode) {
		super(messageCode);
	}

	public AiException(MessageCode messageCode, String message) {
		super(messageCode, message);
	}

	public AiException(MessageCode messageCode, Object... messageArguments) {
		super(messageCode, messageArguments);
	}

	public AiException(MessageCode messageCode, Throwable cause) {
		super(messageCode, cause);
	}
}