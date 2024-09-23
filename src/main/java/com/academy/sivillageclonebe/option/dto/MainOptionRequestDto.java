package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MainOptionRequestDto {

    private String productCode;
    private String mainOptionName;

    public MainOption toEntity(Product product) {
     return MainOption.builder()
             .mainOptionName(mainOptionName)
             .product(product)
             .build();
    }
}
