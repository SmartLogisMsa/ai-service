package com.smartlogis.aiservice.application.service;

import java.util.Map;

import org.springframework.core.io.Resource;

import com.smartlogis.aiservice.application.dto.AiResponse;

public interface AiCreateService {
	public AiResponse generate(String prompt, Map<String, Object> params, String model);
	public AiResponse generate(Resource prompt, Map<String, Object> params, String model);
}
