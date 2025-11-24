package com.smartlogis.aiservice.application.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.smartlogis.aiservice.presentation.dto.DeliveryDeadlineRequest;
import com.smartlogis.aiservice.presentation.dto.Product;

public record DeliveryDeadlineCommand(
	UUID orderId,
	String ordererName,
	String ordererEmail,
	String orderProducts,
	LocalDateTime orderDate,
	String orderMemo,
	String startHub,
	String stopoverHub,
	String arrivalAddress,
	LocalDateTime estimateTime,
	String staffName,
	String staffEmail
) {
	public static DeliveryDeadlineCommand of(DeliveryDeadlineRequest request) {
		return new DeliveryDeadlineCommand(
			request.getOrderId(),
			request.getOrderer().getName(),
			request.getOrderer().getEmail(),
			getProducts(request.getProducts()),
			request.getOrderDate(),
			request.getOrderMemo(),
			request.getStartHub(),
			request.getStopoverHub(),
			request.getArrivalAddress(),
			request.getEstimateTime(),
			request.getStaff().getName(),
			request.getStaff().getEmail()
		);
	}

	private static String getProducts(List<Product> products) {
		if (products.size() == 1) {
			Product p = products.getFirst();
			return "%s %d개".formatted(p.getName(), p.getQuantity());
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("총 ").append(products.size()).append("개 상품\n");

			products.forEach(p -> {
				builder.append("- ")
					.append(p.getName())
					.append(" ")
					.append(p.getQuantity())
					.append("개\n");
			});

			return builder.toString().trim();
		}
	}
}
