package com.academy.sivillageclonebe.orders.vo;

import com.academy.sivillageclonebe.orders.dto.OrderedProductsRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersStatusUpdateDto;
import com.academy.sivillageclonebe.orders.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OrdersStatusUpdateVo {
    private OrderStatus orderStatus;

    @Builder
    public OrdersStatusUpdateDto toDto() {
        return OrdersStatusUpdateDto.builder()
                .orderStatus(orderStatus)
                .build();
    }
}
