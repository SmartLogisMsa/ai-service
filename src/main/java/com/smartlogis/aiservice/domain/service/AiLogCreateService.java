package com.smartlogis.aiservice.domain.service;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.AiType;

public interface AiLogCreateService {
	AiLog create(AiType type, String prompt, String model);
}
