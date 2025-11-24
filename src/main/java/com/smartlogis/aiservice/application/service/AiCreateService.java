package com.smartlogis.aiservice.application.service;

import java.util.Map;

import org.springframework.core.io.Resource;

import com.smartlogis.aiservice.application.dto.AiCreateResult;

public interface AiCreateService {
	AiCreateResult create(String prompt, Map<String, Object> params, String model);
	AiCreateResult create(Resource prompt, Map<String, Object> params, String model);
}
