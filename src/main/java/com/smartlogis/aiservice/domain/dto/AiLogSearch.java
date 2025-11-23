package com.smartlogis.aiservice.domain.dto;

import com.smartlogis.aiservice.domain.AiStatus;
import com.smartlogis.aiservice.domain.AiType;

public record AiLogSearch (
	AiType type,
	AiStatus status,
	String model
) {}
