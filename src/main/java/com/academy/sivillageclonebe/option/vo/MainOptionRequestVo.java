package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.dto.MainOptionRequestDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MainOptionRequestVo {

    private String productCode;
    private String mainOptionName;

    public MainOptionRequestDto toDto() {
        return MainOptionRequestDto.builder()
                .productCode(productCode)
                .mainOptionName(mainOptionName)
                .build();
    }

}
