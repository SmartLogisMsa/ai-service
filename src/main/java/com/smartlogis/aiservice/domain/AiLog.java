package com.smartlogis.aiservice.domain;

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
	@Column(nullable = false)
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

	public static AiLog create(AiType type, String prompt, String model) {
		validateType(type);
		validatePrompt(prompt);
		validateModel(model);

		AiLog aiLog = new AiLog();

		aiLog.type = type;
		aiLog.prompt = prompt;
		aiLog.model = model;

		return aiLog;
	}

	public void success(String fullPrompt, String response, Long latency) {
		validateLatency(latency);

		this.fullPrompt = fullPrompt;
		this.response = response;
		this.latency = latency;
		this.status = AiStatus.SUCCESS;
	}

	public void fail(String fullPrompt, String errorMessage) {
		this.fullPrompt = fullPrompt;
		this.errorMessage = errorMessage;
		this.status = AiStatus.FAIL;
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

	private void validateLatency(Long latency) {
		if (latency == null || latency <= 0) {
			throw new IllegalArgumentException("AI 응답시간(latency)은 0 이하일 수 없습니다.");
		}
	}
}
