package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductSizes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductSizesRequestDto {

    private String sizeName;

    public ProductSizes toEntity() {
        return ProductSizes.builder()
                .sizeName(sizeName)
                .build();
    }
}
