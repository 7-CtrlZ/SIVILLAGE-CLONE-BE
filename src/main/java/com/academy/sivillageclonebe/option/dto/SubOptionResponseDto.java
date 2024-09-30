package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStatus;
import com.academy.sivillageclonebe.option.entity.SubOption;
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
    private Long subOptionId;
    private String subOptionName;
    private ProductStatus productStatus;

    public SubOptionResponseVo toVo() {
        return SubOptionResponseVo.builder()
                .mainOptionId(mainOptionId)
                .subOptionId(subOptionId)
                .subOptionName(subOptionName)
                .productStatus(productStatus)
                .build();
    }
    public static SubOptionResponseDto from(SubOption subOption) {
        return SubOptionResponseDto.builder()
                .mainOptionId(subOption.getId())
                .subOptionId(subOption.getId())
                .subOptionName(subOption.getSubOptionName())
                .productStatus(subOption.getProductStatus())
                .build();
    }
}
