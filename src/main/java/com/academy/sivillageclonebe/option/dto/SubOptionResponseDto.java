package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStatus;
import com.academy.sivillageclonebe.option.vo.SubOptionResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubOptionResponseDto {

    private Long mainOptionId;
    private String optionName;
    private ProductStatus productStatus;

    public SubOptionResponseVo toVo() {
        return SubOptionResponseVo.builder()
                .mainOptionId(mainOptionId)
                .optionName(optionName)
                .productStatus(productStatus)
                .build();
    }
}
