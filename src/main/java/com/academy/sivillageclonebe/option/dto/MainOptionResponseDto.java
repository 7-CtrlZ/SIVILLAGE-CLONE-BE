package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.MainOptionResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainOptionResponseDto {
    private Long productId;
    private Long mainOptionId;
    private String mainOptionName;

    public MainOptionResponseVo toVo() {
        return MainOptionResponseVo.builder()
                .productId(productId)
                .mainOptionId(mainOptionId)
                .mainOptionName(mainOptionName)
                .build();
    }
}
