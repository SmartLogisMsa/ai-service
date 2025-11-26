package com.smartlogis.aiservice.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.smartlogis.aiservice.infrastructure.SpringAiModel;
import com.smartlogis.aiservice.presentation.annotation.EnumValid;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "최종 발송 시한 요청")
public class DeliveryDeadlineRequest {
	@NotNull @EnumValid(enumClass = SpringAiModel.class)
	@Schema(description = "AI 모델", defaultValue = "vertex_ai_gemini")
	private String model = "vertex_ai_gemini";

	@NotNull
	@Schema(description = "주문 ID", example = "550e8400-e29b-41d4-a716-446655440000")
	private UUID orderId;

	@NotNull
	@Schema(description = "주문자 정보")
	private Orderer orderer;

	@NotEmpty
	@Schema(description = "주문 상품 목록")
	private List<Product> products;

	@NotNull
	@Schema(description = "주문 일자", example = "2025-11-24T12:00:00")
	private LocalDateTime orderDate;

	@Schema(description = "주문 메모")
	private String orderMemo;

	@NotBlank
	@Schema(description = "출발 허브", example = "강남구 도곡로 112")
	private String startHub;

	@Schema(description = "경유 허브")
	private List<String> stopoverHub;

	@NotBlank
	@Schema(description = "도착 허브", example = "전라북도 군산시 조촌동 123")
	private String arrivalHub;

	@NotBlank
	@Schema(description = "배송 주소", example = "전라북도 군산시 궁포안2길 27 1층 123호")
	private String address;

	@NotNull
	@Schema(description = "예상 소요 시간", example = "4.5")
	private Double estimateTime;

	@NotNull
	@Schema(description = "배송 담당자 정보")
	private Staff staff;

	@Data
	@NoArgsConstructor
	@Schema(description = "주문자 정보")
	public static class Orderer {
		@NotBlank
		@Schema(description = "주문자 이름", example = "홍길동")
		private String name;

		@NotBlank
		@Email
		@Schema(description = "주문자 이메일", example = "hong@test.com")
		private String email;
	}

	@Data
	@NoArgsConstructor
	@Schema(description = "배송 담당자 정보")
	public static class Staff {
		@NotBlank
		@Schema(description = "담당자 이름", example = "김철수")
		private String name;

		@NotBlank
		@Email
		@Schema(description = "담당자 이메일", example = "kim@test.com")
		private String email;
	}
}