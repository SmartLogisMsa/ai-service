package com.smartlogis.aiservice.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.dto.AiLogSearch;

public interface AiLogQueryService {
	AiLog getAiLogById(Long id);
	Page<AiLog> getAiLogs(AiLogSearch search, Pageable pageable);
}
