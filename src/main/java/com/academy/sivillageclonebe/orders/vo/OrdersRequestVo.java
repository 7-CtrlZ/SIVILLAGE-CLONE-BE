package com.academy.sivillageclonebe.orders.vo;

import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OrdersRequestVo {
    private String receiverName;
    private String receiverPhone;
    private Long totalPrice;
    private String address;
    private String zipCode;
    private String request;

    @Builder
    public OrdersRequestDto toDto() {
        return OrdersRequestDto.builder()
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .totalPrice(totalPrice)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .build();
    }
}
