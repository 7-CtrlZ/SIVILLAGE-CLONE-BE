package com.academy.sivillageclonebe.orders.dto;

import com.academy.sivillageclonebe.orders.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersStatusUpdateDto {
    private OrderStatus orderStatus;

}
