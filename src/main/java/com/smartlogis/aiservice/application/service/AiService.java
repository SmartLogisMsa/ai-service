package com.smartlogis.aiservice.application.service;

import com.smartlogis.aiservice.application.dto.AiLogSearchCommand;
import com.smartlogis.aiservice.application.dto.DeliveryDeadlineCommand;
import com.smartlogis.aiservice.application.dto.PageCommand;
import com.smartlogis.aiservice.presentation.dto.AiCreateResponse;
import com.smartlogis.aiservice.presentation.dto.AiLogResponse;
import com.smartlogis.common.presentation.dto.PageResponse;

public interface AiService {
	AiCreateResponse deliveryDeadlineMessage(String model, DeliveryDeadlineCommand command);
	AiLogResponse getAiLogById(Long id);
	PageResponse<AiLogResponse> getAiLogs(AiLogSearchCommand search, PageCommand page);
}
