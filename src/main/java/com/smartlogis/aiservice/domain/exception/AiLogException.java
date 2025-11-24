package com.smartlogis.aiservice.domain.exception;

import com.smartlogis.common.exception.AbstractException;
import com.smartlogis.common.exception.MessageCode;

public class AiLogException extends AbstractException {
	public AiLogException(MessageCode messageCode) {
		super(messageCode);
	}

	public AiLogException(MessageCode messageCode, String message) {
		super(messageCode, message);
	}

	public AiLogException(MessageCode messageCode, Object... messageArguments) {
		super(messageCode, messageArguments);
	}

	public AiLogException(MessageCode messageCode, Throwable cause) {
		super(messageCode, cause);
	}
}