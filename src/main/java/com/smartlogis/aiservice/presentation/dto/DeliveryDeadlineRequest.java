package com.smartlogis.aiservice.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
	@Schema(description = "출발 허브")
	private String startHub;

	@Schema(description = "경유 허브")
	private String stopoverHub;

	@NotBlank
	@Schema(description = "도착 주소")
	private String arrivalAddress;

	@NotNull
	@Schema(description = "예상 도착 시간", example = "2025-11-25T15:30:00")
	private LocalDateTime estimateTime;

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