package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStocks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStocksRequestDto {

    private Long productByOptionId;
    private Integer quantity;

    public ProductStocks toEntity() {
        return ProductStocks.builder()
                .productsByOptionId(productByOptionId)
                .quantity(quantity)
                .build();
    }
}
