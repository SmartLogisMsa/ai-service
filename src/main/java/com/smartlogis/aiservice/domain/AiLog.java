package com.smartlogis.aiservice.domain;

import com.smartlogis.aiservice.domain.dto.AiLogCreate;
import com.smartlogis.aiservice.domain.exception.AiLogException;
import com.smartlogis.aiservice.domain.exception.AiLogMessageCode;
import com.smartlogis.common.domain.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "p_ai_log")
@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AiLog extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private AiType type;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String prompt;

	@Column(columnDefinition = "TEXT")
	private String fullPrompt;

	@Column(columnDefinition = "TEXT")
	private String response;

	@Column
	private String errorMessage;

	@Enumerated(EnumType.STRING)
	@Column
	private AiStatus status;

	@Column(nullable = false)
	private String model;

	@Column
	private Long latency;

	public static AiLog create(AiLogCreate request) {
		validateType(request.type());
		validatePrompt(request.prompt());
		validateModel(request.model());
		validateLatency(request.latency());

		AiLog aiLog = new AiLog();

		aiLog.type = request.type();
		aiLog.prompt = request.prompt();
		aiLog.fullPrompt = request.fullPrompt();
		aiLog.response = request.response();
		aiLog.errorMessage = request.errorMessage();
		aiLog.status = request.status();
		aiLog.model = request.model();
		aiLog.latency = request.latency();

		return aiLog;
	}

	public void delete() { throw new AiLogException(AiLogMessageCode.DELETE_NOT_ALLOWED); }

	private static void validateType(AiType type) {
		if (type == null) {
			throw new IllegalArgumentException("AI 요청타입(type)은 비어있을 수 없습니다.");
		}
	}

	private static void validatePrompt(String prompt) {
		if (prompt == null || prompt.isBlank()) {
			throw new IllegalArgumentException("AI 요청값(prompt)은 비어있을 수 없습니다.");
		}
	}

	private static void validateModel(String model) {
		if (model == null || model.isBlank()) {
			throw new IllegalArgumentException("AI 모델(model)은 비어있을 수 없습니다.");
		}
	}

	private static void validateLatency(Long latency) {
		if (latency != null && latency <= 0) {
			throw new IllegalArgumentException("AI 응답시간(latency)은 0 이하일 수 없습니다.");
		}
	}
}
