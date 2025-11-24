package com.smartlogis.aiservice.application.service;

import com.smartlogis.aiservice.application.dto.DeliveryDeadlineCommand;
import com.smartlogis.aiservice.presentation.dto.AiCreateResponse;

public interface AiService {
	AiCreateResponse deliveryDeadlineMessage(String model, DeliveryDeadlineCommand command);
}
