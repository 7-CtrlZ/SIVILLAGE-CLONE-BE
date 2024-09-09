package com.academy.sivillageclonebe.cart.vo;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CartRequestVo {

    private Long memberId;
    private Long productsId;
    private Long productsByOptionId;
    private Integer quantity;
    private boolean isChecked;

    @Builder
    public CartDto toDto(Integer brandId) {
        return CartDto.builder()
                .memberId(memberId)
                .brandId(brandId)
                .build();
    }

}
