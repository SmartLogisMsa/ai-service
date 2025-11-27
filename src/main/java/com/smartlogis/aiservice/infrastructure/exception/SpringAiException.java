package com.smartlogis.aiservice.infrastructure.exception;

import com.smartlogis.common.exception.AbstractException;
import com.smartlogis.common.exception.MessageCode;

public class SpringAiException extends AbstractException {
	public SpringAiException(MessageCode messageCode) {
		super(messageCode);
	}

	public SpringAiException(MessageCode messageCode, String message) {
		super(messageCode, message);
	}

	public SpringAiException(MessageCode messageCode, Object... messageArguments) {
		super(messageCode, messageArguments);
	}

	public SpringAiException(MessageCode messageCode, Throwable cause) {
		super(messageCode, cause);
	}
}