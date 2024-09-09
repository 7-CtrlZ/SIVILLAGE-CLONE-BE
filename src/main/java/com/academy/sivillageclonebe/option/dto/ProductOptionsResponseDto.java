package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.ProductOptionsResponseVo;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductOptionsResponseDto {

    private Integer id;
    private String optionName;

    public ProductOptionsResponseVo toVo() {
        return ProductOptionsResponseVo.builder()
                .optionName(optionName)
                .build();
    }
}
