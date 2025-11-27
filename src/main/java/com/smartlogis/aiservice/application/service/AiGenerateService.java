package com.smartlogis.aiservice.application.service;

import java.util.Map;

import org.springframework.core.io.Resource;

import com.smartlogis.aiservice.application.dto.AiCreateResult;

public interface AiGenerateService {
	AiCreateResult generate(String prompt, Map<String, Object> params, String model);
	AiCreateResult generate(Resource prompt, Map<String, Object> params, String model);
}
