package com.academy.sivillageclonebe.option.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainOptionResponseVo {

    private Long productId;
    private Long mainOptionId;
    private String mainOptionName;
}
