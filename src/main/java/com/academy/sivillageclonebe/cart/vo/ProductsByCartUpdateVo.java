package com.academy.sivillageclonebe.cart.vo;

import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ProductsByCartUpdateVo {
    private Long subOptionId;
    private Integer quantity;

    @Builder
    public ProductsByCartUpdateDto toDto() {
        return ProductsByCartUpdateDto.builder()
                .subOptionId(subOptionId)
                .quantity(quantity)
                .build();
    }
}
