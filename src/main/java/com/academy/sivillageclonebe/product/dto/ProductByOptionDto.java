package com.academy.sivillageclonebe.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByOptionDto {
    private String colorName;
    private String sizeName;
    private String statusName;
    private String optionName;
}
