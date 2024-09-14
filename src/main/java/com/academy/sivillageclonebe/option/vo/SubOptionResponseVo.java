package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubOptionResponseVo {

    private String optionName;
    private ProductStatus productStatus;
    private Long mainOptionId;

}
