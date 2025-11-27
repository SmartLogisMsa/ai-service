package com.smartlogis.aiservice.presentation.controller;

import static com.smartlogis.common.presentation.ApiResponse.*;
import static org.springframework.http.ResponseEntity.*;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogis.aiservice.application.dto.AiLogSearchCommand;
import com.smartlogis.aiservice.application.dto.DeliveryDeadlineCommand;
import com.smartlogis.aiservice.application.dto.PageCommand;
import com.smartlogis.aiservice.application.service.AiService;
import com.smartlogis.aiservice.presentation.dto.AiCreateResponse;
import com.smartlogis.aiservice.presentation.dto.AiLogResponse;
import com.smartlogis.aiservice.presentation.dto.AiLogSearchRequest;
import com.smartlogis.aiservice.presentation.dto.DeliveryDeadlineRequest;
import com.smartlogis.common.presentation.ApiResponse;
import com.smartlogis.common.presentation.dto.PageRequest;
import com.smartlogis.common.presentation.dto.PageResponse;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AiController {

	private final AiService aiService;

	@Operation(summary = "최종 발송 시한 메세지 생성 요청")
	@PostMapping("/delivery-deadline")
	public ResponseEntity<ApiResponse<AiCreateResponse>> deliveryDeadline(
		@Valid @RequestBody DeliveryDeadlineRequest request
	) {
		DeliveryDeadlineCommand command = DeliveryDeadlineCommand.of(request);
		AiCreateResponse response = aiService.deliveryDeadlineMessage(request.getModel(), command);
		return ok(successWithDataOnly(response));
	}

	@Operation(summary = "AI 로그 목록 조회")
	@PreAuthorize("hasRole('MASTER')")
	@GetMapping("/logs")
	public ResponseEntity<ApiResponse<PageResponse<AiLogResponse>>> getAiLogById(
		@ParameterObject AiLogSearchRequest search,
		@ParameterObject PageRequest page
	) {
		PageResponse<AiLogResponse> aiLogs = aiService.getAiLogs(AiLogSearchCommand.of(search), PageCommand.of(page));
		return ok(successWithDataOnly(aiLogs));
	}

	@Operation(summary = "AI 로그 단건 조회")
	@PreAuthorize("hasRole('MASTER')")
	@GetMapping("/logs/{logId}")
	public ResponseEntity<ApiResponse<AiLogResponse>> getAiLogById(
		@PathVariable Long logId
	) {
		AiLogResponse aiLog = aiService.getAiLogById(logId);
		return ok(successWithDataOnly(aiLog));
	}

}
