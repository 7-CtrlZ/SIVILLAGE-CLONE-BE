package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.dto.ProductStocksRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStocksRequestVo {

    private Integer quantity;

    public ProductStocksRequestDto toDto(Long subOptionId) {
        return ProductStocksRequestDto.builder()
                .subOptionId(subOptionId)
                .orderQuantity(quantity)
                .build();
    }
}
