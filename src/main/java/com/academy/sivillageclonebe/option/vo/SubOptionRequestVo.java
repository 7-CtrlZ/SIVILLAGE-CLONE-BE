package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.dto.SubOptionRequestDto;
import com.academy.sivillageclonebe.option.entity.ProductStatus;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SubOptionRequestVo {

    private Long mainOptionId;
    private String subOptionName;
    private ProductStatus productStatus;

    public SubOptionRequestDto toDto() {
        return SubOptionRequestDto.builder()
                .mainOptionId(mainOptionId)
                .subOptionName(subOptionName)
                .productStatus(productStatus)
                .build();
    }
}
