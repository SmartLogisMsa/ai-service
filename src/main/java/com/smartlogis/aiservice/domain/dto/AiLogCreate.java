package com.smartlogis.aiservice.domain.dto;

import com.smartlogis.aiservice.domain.AiStatus;
import com.smartlogis.aiservice.domain.AiType;

public record AiLogCreate (
	AiType type,
	String prompt,
	String fullPrompt,
	String response,
	String errorMessage,
	AiStatus status,
	String model,
	Long latency
) {}