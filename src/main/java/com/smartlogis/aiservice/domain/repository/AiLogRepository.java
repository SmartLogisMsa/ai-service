package com.smartlogis.aiservice.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.smartlogis.aiservice.domain.AiLog;

public interface AiLogRepository extends Repository<AiLog, Long>, AiLogRepositoryCustom {
	AiLog save(AiLog aiLog);
	Optional<AiLog> findById(Long id);
}
