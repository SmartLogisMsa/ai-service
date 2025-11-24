package com.smartlogis.aiservice.application.service;

import java.util.Map;

import org.springframework.core.io.Resource;

import com.smartlogis.aiservice.application.dto.AiResult;

public interface AiCreateService {
	AiResult create(String prompt, Map<String, Object> params, String model);
	AiResult create(Resource prompt, Map<String, Object> params, String model);
}
