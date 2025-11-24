package com.smartlogis.aiservice.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.domain.repository.AiLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AiLogCreateServiceImpl implements AiLogCreateService {

	private final AiLogRepository repository;

	@Override
	public AiLog create(AiType type, String prompt, String model) {
		AiLog aiLog = AiLog.create(type, prompt, model);

		repository.save(aiLog);

		return aiLog;
	}
}
