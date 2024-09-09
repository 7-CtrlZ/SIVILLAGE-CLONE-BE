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

    // ProductsByCart 엔티티를 ProductsByCartDto로 변환하는 메서드
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

    // ProductsByCartDto를 ProductsByCart 엔티티로 변환하는 메서드
    public ProductsByCart toEntity(Cart cart) {
        return ProductsByCart.builder()
                .cart(cart)
                .productsId(this.productsId)
                .productsByOptionId(this.productsByOptionId)
                .quantity(this.quantity)
                .isChecked(true)
                .build();
    }

}
