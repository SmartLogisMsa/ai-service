package com.smartlogis.aiservice.presentation.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "주문 상품 정보")
public class Product {
	@NotNull
	@Schema(description = "상품 ID", example = "550e8400-e29b-41d4-a716-446655440000")
	private UUID id;

	@NotBlank
	@Schema(description = "상품 이름", example = "노트북")
	private String name;

	@NotNull
	@Schema(description = "상품 수량", example = "2")
	private Integer quantity;
}
