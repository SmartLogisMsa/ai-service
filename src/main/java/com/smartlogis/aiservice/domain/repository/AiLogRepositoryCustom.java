package com.smartlogis.aiservice.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.dto.AiLogSearch;

public interface AiLogRepositoryCustom {
	Page<AiLog> getAiLogs(AiLogSearch search, Pageable pageable);
}
