package com.academy.sivillageclonebe.option.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStocksResponseVo {

    private Long subOptionId;
    private Integer quantity;
}
