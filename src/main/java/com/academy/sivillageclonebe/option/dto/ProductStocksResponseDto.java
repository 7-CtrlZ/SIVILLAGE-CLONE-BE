package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStocks;
import com.academy.sivillageclonebe.option.vo.ProductStocksResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStocksResponseDto {

    private Long subOptionId;
    private Integer quantity;

    public ProductStocksResponseVo toVo() {
        return ProductStocksResponseVo.builder()
                .subOptionId(subOptionId)
                .quantity(quantity)
                .build();
    }
}
