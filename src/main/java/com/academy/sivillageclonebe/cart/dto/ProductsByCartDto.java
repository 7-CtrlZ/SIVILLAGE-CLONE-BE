package com.academy.sivillageclonebe.cart.dto;

import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductsByCartDto {

    private Long id;
    private Long cartId;
    private String productCode;
    private Long subOptionId;
    private Integer quantity;
    private boolean isChecked;

    public static ProductsByCartDto fromEntity(ProductsByCart productsByCart) {
        return ProductsByCartDto.builder()
                .id(productsByCart.getId())
                .cartId(productsByCart.getCart().getId())
                .productCode(productsByCart.getProductCode())
                .subOptionId(productsByCart.getSubOptionId())
                .quantity(productsByCart.getQuantity())
                .isChecked(productsByCart.isChecked())
                .build();
    }

    public ProductsByCart toEntity(Cart cart) {
        return ProductsByCart.builder()
                .cart(cart)
                .productCode(productCode)
                .subOptionId(subOptionId)
                .quantity(quantity)
                .isChecked(true)
                .build();
    }

}
