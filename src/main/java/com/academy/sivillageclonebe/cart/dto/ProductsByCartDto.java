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
    private Long productsId;
    private Long productsByOptionId;
    private Integer quantity;
    private boolean isChecked;

    public static ProductsByCartDto fromEntity(ProductsByCart productsByCart) {
        return ProductsByCartDto.builder()
                .id(productsByCart.getId())
                .cartId(productsByCart.getCart().getId())
                .productsId(productsByCart.getProductsId())
                .productsByOptionId(productsByCart.getProductsByOptionId())
                .quantity(productsByCart.getQuantity())
                .isChecked(productsByCart.isChecked())
                .build();
    }

    public ProductsByCart toEntity(Cart cart) {
        return ProductsByCart.builder()
                .cart(cart)
                .productsId(productsId)
                .productsByOptionId(productsByOptionId)
                .quantity(quantity)
                .isChecked(true)
                .build();
    }

}
