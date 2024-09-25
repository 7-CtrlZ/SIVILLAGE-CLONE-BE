package com.academy.sivillageclonebe.orders.vo;

import com.academy.sivillageclonebe.orders.dto.OrderedProductsRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OrderedProductsRequestVo {
    private Long productId;
    private String orderedMainOption;
    private String orderedSubOption;
    private Integer quantity;

    @Builder
    public OrderedProductsRequestDto toDto() {
        return OrderedProductsRequestDto.builder()
                .productId(productId)
                .orderedMainOption(orderedMainOption)
                .orderedSubOption(orderedSubOption)
                .quantity(quantity)
                .build();
    }
}
