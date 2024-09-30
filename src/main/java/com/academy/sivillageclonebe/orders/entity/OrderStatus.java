package com.academy.sivillageclonebe.orders.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    DONE("결제 완료"),
    SHIPPED("배송 중"),
    DELIVERED("배송 완료"),
    CANCELLED("주문 취소"),
    RETURN_REQUESTED("반품 요청"),
    RETURNED("반품 완료"),
    REFUNDED("환불 완료");

    private final String orderStatus;

    @JsonValue
    public String getOrderStatus() {
        return orderStatus;
    }

    @JsonCreator
    public static OrderStatus fromOrderStatus(String value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getOrderStatus().equals(value)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + value);
    }
}
