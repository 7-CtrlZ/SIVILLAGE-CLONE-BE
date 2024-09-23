package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStocks;
import com.academy.sivillageclonebe.option.entity.SubOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStocksRequestDto {

    private Long subOptionId;
    private Integer orderQuantity;

    public ProductStocks toEntity(SubOption subOption, Integer changeNum) {
        return ProductStocks.builder()
                .subOption(subOption)
                .quantity(changeNum)
                .build();
    }
}
