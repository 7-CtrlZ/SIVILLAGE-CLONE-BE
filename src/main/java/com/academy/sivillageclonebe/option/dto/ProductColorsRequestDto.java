package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductColors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductColorsRequestDto {

    private String colorName;

    public ProductColors toEntity() {
        return ProductColors.builder()
                .colorName(colorName)
                .build();
    }
}
