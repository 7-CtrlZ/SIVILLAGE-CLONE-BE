package com.academy.sivillageclonebe.cart.dto;

import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<ProductsByCartDto> products;

    public static CartDto fromEntity(Cart cart, List<ProductsByCart> productsByCartList) {
        List<ProductsByCartDto> products = productsByCartList.stream()
                .map(ProductsByCartDto::fromEntity)
                .collect(Collectors.toList());

        return CartDto.builder()
                .id(cart.getId())
                .memberId(cart.getMemberId())
                .brandId(cart.getBrandId())
                .products(products)
                .build();
    }

    public Cart toEntity() {
        return Cart.builder()
                .memberId(memberId)
                .brandId(brandId)
                .build();
    }

}
