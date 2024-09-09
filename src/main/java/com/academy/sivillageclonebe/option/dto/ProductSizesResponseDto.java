package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.ProductSizesResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductSizesResponseDto {

    private Integer id;
    private String sizeName;

    public ProductSizesResponseVo toVo() {
        return ProductSizesResponseVo.builder()
                .id(id)
                .sizeName(sizeName)
                .build();
    }
}
