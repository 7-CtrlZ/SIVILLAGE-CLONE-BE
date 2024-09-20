package com.academy.sivillageclonebe.orders.dto;

import com.academy.sivillageclonebe.orders.entity.OrderedProducts;
import com.academy.sivillageclonebe.orders.entity.Orders;
import com.academy.sivillageclonebe.orders.vo.OrderedProductsResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProductsRequestDto {
    private Orders orders;
    private Long productId;
    private String orderedMainOption;
    private String orderedSubOption;
    private Long price;
    private Integer quantity;

    public OrderedProducts toEntity() {
        return OrderedProducts.builder()
                .orders(orders)
                .productId(productId)
                .orderedMainOption(orderedMainOption)
                .orderedSubOption(orderedSubOption)
                .price(price)
                .quantity(quantity)
                .build();
    }

    public static OrderedProductsRequestDto fromEntity(OrderedProducts orderedProducts) {
        return OrderedProductsRequestDto.builder()
                .productId(orderedProducts.getProductId())
                .orderedMainOption(orderedProducts.getOrderedMainOption())
                .orderedSubOption(orderedProducts.getOrderedSubOption())
                .price(orderedProducts.getPrice())
                .quantity(orderedProducts.getQuantity())
                .build();
    }

    public OrderedProductsResponseVo toVo() {
        return OrderedProductsResponseVo.builder()
                .productId(productId)
                .orderedMainOption(orderedMainOption)
                .orderedSubOption(orderedSubOption)
                .price(price)
                .quantity(quantity)
                .build();
    }

}
