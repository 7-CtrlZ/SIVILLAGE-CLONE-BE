package com.academy.sivillageclonebe.orders.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.orders.entity.OrderStatus;
import com.academy.sivillageclonebe.orders.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRequestDto {
    private String receiverName;
    private String receiverPhone;
    private Long totalPrice;
    private String address;
    private String zipCode;
    private String request;

    public Orders toEntity(Member member) {
        return Orders.builder()
                .orderStatus(OrderStatus.DONE)
                .ordererName(member.getName())
                .ordererPhone(member.getPhone())
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .totalPrice(totalPrice)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .build();
    }
}
