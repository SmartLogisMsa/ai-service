package com.smartlogis.aiservice.presentation.dto;

import com.smartlogis.aiservice.domain.AiStatus;
import com.smartlogis.aiservice.domain.AiType;
import com.smartlogis.aiservice.presentation.annotation.EnumValid;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AiLogSearchRequest {
	@Schema(description = "AI 요청 타입")
	@EnumValid(enumClass = AiType.class) private String aiType;

	@Schema(description = "AI 응답 상태")
	@EnumValid(enumClass = AiStatus.class) private String aiStatus;

	@Schema(description = "AI 모델")
	String model;
}
