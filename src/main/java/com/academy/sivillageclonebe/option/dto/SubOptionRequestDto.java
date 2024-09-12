package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.entity.ProductOptions;
import com.academy.sivillageclonebe.option.entity.ProductStatus;
import com.academy.sivillageclonebe.option.entity.SubOption;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubOptionRequestDto {

    private Long mainOptionId;
    private Integer productOptionId;
    private Integer productStatusId;
    private Boolean isActive;
    private Boolean isDeleted;

    public SubOption toEntity(MainOption mainOption, ProductOptions productOptions, ProductStatus productStatus) {
        return SubOption.builder()
                .isActive(isActive)
                .isDeleted(isDeleted)
                .mainOption(mainOption)
                .productOptions(productOptions)
                .productStatus(productStatus)
                .build();
    }
}
