package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.ProductColorsResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductColorsResponseDto {

    private Integer id;
    private String colorName;

    public ProductColorsResponseVo toVo() {
        return ProductColorsResponseVo.builder()
                .id(id)
                .colorName(colorName)
                .build();
    }
}
