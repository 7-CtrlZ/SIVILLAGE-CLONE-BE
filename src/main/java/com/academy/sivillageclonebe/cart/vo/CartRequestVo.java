package com.academy.sivillageclonebe.cart.vo;

import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CartRequestVo {

    private Long productsId;
    private Long subOptionId;
    private Integer quantity;
    private boolean isChecked;

    @Builder
    public ProductsByCartDto toProductsByCartDto() {
        return ProductsByCartDto.builder()
                .productsId(productsId)
                .subOptionId(subOptionId)
                .quantity(quantity)
                .isChecked(isChecked)
                .build();
    }

}
