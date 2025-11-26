package com.smartlogis.aiservice.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AiLogSearchRequest {
	String aiType;
	String aiStatus;
	String model;
}
