package com.smartlogis.aiservice.application.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.smartlogis.aiservice.presentation.dto.DeliveryDeadlineRequest;
import com.smartlogis.aiservice.presentation.dto.Product;

public record DeliveryDeadlineCommand(
	UUID orderId,
	String ordererName,
	String ordererEmail,
	List<Product> orderProducts,
	LocalDateTime orderDate,
	String orderMemo,
	String startHub,
	List<String> stopoverHub,
	String arrivalHub,
	String address,
	Double estimateTime,
	String staffName,
	String staffEmail
) {
	public static DeliveryDeadlineCommand of(DeliveryDeadlineRequest request) {
		return new DeliveryDeadlineCommand(
			request.getOrderId(),
			request.getOrderer().getName(),
			request.getOrderer().getEmail(),
			request.getProducts(),
			request.getOrderDate(),
			request.getOrderMemo(),
			request.getStartHub(),
			request.getStopoverHub(),
			request.getArrivalHub(),
			request.getAddress(),
			request.getEstimateTime(),
			request.getStaff().getName(),
			request.getStaff().getEmail()
		);
	}

	private String getProducts() {
		if (orderProducts.size() == 1) {
			Product p = orderProducts.getFirst();
			return "%s %d개".formatted(p.getName(), p.getQuantity());
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("총 ").append(orderProducts.size()).append("개 상품\n");

			orderProducts.forEach(p -> {
				builder.append("- ")
					.append(p.getName())
					.append(" ")
					.append(p.getQuantity())
					.append("개\n");
			});

			return builder.toString().trim();
		}
	}

	private String getStopoverHub() {
		if (stopoverHub == null || stopoverHub.isEmpty()) return "";

		if (stopoverHub.size() == 1) {
			return stopoverHub.getFirst();
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("\n");

			stopoverHub.forEach(h -> {
				builder.append("- ").append(h).append("\n");
			});

			return builder.toString().trim();
		}
	}

	public Map<String, Object> getParams() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		Map<String, Object> params = new HashMap<>();
		params.put("order_id", this.orderId());
		params.put("orderer_name", this.ordererName());
		params.put("orderer_email", this.ordererEmail());
		params.put("order_date", formatter.format(this.orderDate()));
		params.put("order_products", getProducts());
		params.put("order_memo", this.orderMemo() == null ? "" : this.orderMemo());
		params.put("start_hub", this.startHub());
		params.put("stopover_hub", getStopoverHub());
		params.put("arrival_hub", this.arrivalHub());
		params.put("address", this.address());
		params.put("estimate_time", this.estimateTime() + "시간");
		params.put("staff_name", this.staffName());
		params.put("staff_email", this.staffEmail());

		return params;
	}
}
