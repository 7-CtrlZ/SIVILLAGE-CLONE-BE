package com.academy.sivillageclonebe.cart.vo;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CartRequestVo {

    private Long productsId;
    private Long productsByOptionId;
    private Integer quantity;
    private boolean isChecked;

    @Builder
    public CartDto toDto(Long memberId, Integer brandId) {
        return CartDto.builder()
                .memberId(memberId)
                .brandId(brandId)
                .build();
    }

    @Builder
    public ProductsByCartDto toProductsByCartDto() {
        return ProductsByCartDto.builder()
                .productsId(productsId)
                .productsByOptionId(productsByOptionId)
                .quantity(quantity)
                .isChecked(isChecked)
                .build();
    }

}
