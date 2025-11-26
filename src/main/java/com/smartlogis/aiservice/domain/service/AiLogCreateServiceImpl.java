package com.smartlogis.aiservice.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.dto.AiLogCreate;
import com.smartlogis.aiservice.domain.repository.AiLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AiLogCreateServiceImpl implements AiLogCreateService {

	private final AiLogRepository repository;

	@Override
	public AiLog create(AiLogCreate request) {
		AiLog aiLog = AiLog.create(request);

		repository.save(aiLog);

		return aiLog;
	}
}
