package com.academy.sivillageclonebe.orders.vo;

import com.academy.sivillageclonebe.orders.entity.OrderedProducts;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProductsResponseVo {

    private Long productId;

    private String orderedMainOption;

    private String orderedSubOption;

    private Long price;

    private Integer quantity;

    public static OrderedProductsResponseVo fromEntity(OrderedProducts orderedProducts) {
        return OrderedProductsResponseVo.builder()
                .productId(orderedProducts.getProductId())
                .orderedMainOption(orderedProducts.getOrderedMainOption())
                .orderedSubOption(orderedProducts.getOrderedSubOption())
                .price(orderedProducts.getPrice())
                .quantity(orderedProducts.getQuantity())
                .build();
    }
}
