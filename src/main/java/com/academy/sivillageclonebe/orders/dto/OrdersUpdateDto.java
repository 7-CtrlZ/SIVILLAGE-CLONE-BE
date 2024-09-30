package com.academy.sivillageclonebe.orders.dto;

import com.academy.sivillageclonebe.orders.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersUpdateDto {
    private String receiverName;
    private String receiverPhone;
    private Long totalPrice;
    private String address;
    private String zipCode;
    private String request;

    public Orders toEntity() {
        return Orders.builder()
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .totalPrice(totalPrice)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .build();
    }
}
