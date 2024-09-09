package com.academy.sivillageclonebe.cart.dto;

import com.academy.sivillageclonebe.cart.entity.Cart;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartDto {

    private Long id;
    private Long memberId;
    private Integer brandId;

    // Cart 엔티티를 CartDto로 변환하는 메서드
    public static CartDto fromEntity(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .memberId(cart.getMemberId())
                .brandId(cart.getBrandId())
                .build();
    }

    // CartDto를 Cart 엔티티로 변환하는 메서드
    public Cart toEntity() {
        return Cart.builder()
                .memberId(this.memberId)
                .brandId(this.brandId)
                .build();
    }

}
