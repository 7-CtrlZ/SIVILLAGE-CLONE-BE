package com.academy.sivillageclonebe.option.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductColorsResponseVo {

    private Integer id;
    private String colorName;
}
