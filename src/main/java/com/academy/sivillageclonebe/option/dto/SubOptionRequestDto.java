package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.entity.ProductStatus;
import com.academy.sivillageclonebe.option.entity.SubOption;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubOptionRequestDto {

    private Long mainOptionId;
    private String subOptionName;
    private ProductStatus productStatus;

    public SubOption toEntity(MainOption mainOption) {
        return SubOption.builder()
                .mainOption(mainOption)
                .subOptionName(subOptionName)
                .productStatus(productStatus)
                .build();
    }
}
