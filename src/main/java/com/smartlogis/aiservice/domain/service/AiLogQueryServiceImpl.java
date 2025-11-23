package com.smartlogis.aiservice.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.dto.AiLogSearch;
import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.domain.exception.AiLogMessageCode;
import com.smartlogis.aiservice.domain.repository.AiLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class AiLogQueryServiceImpl implements AiLogQueryService {

	private final AiLogRepository repository;

	@Override
	public AiLog getAiLogById(Long id) {
		return repository.findById(id).orElseThrow(() -> new AiLogException(AiLogMessageCode.LOG_NOT_FOUND, id));
	}

	@Override
	public Page<AiLog> getAiLogs(AiLogSearch search, Pageable pageable) {
		return repository.getAiLogs(search, pageable);
	}
}
