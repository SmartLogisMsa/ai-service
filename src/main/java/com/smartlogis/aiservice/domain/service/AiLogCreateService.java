package com.smartlogis.aiservice.domain.service;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.dto.AiLogCreate;

public interface AiLogCreateService {
	AiLog create(AiLogCreate request);
}
