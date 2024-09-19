package com.academy.sivillageclonebe.orders.vo;

import com.academy.sivillageclonebe.orders.dto.OrderedProductsRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class OrdersRequestVo {
    private String receiverName;
    private String receiverPhone;
    private Long totalPrice;
    private String address;
    private String zipCode;
    private String request;
    private List<OrderedProductsRequestVo> orderedProducts;

    @Builder
    public OrdersRequestDto toDto() {
        List<OrderedProductsRequestDto> orderedProductsDto = orderedProducts.stream()
                .map(OrderedProductsRequestVo::toDto)
                .collect(Collectors.toList());

        return OrdersRequestDto.builder()
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .totalPrice(totalPrice)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .orderedProducts(orderedProductsDto)
                .build();
    }
}
