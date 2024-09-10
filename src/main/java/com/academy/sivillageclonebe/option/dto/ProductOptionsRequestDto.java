package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductOptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductOptionsRequestDto {

    private String optionName;

    public ProductOptions toEntity() {
        return ProductOptions.builder()
                .optionName(optionName)
                .build();
    }
}
