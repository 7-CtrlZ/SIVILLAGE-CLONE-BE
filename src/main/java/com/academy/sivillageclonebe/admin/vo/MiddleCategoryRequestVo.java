package com.academy.sivillageclonebe.admin.vo;

import com.academy.sivillageclonebe.admin.dto.MiddleCategoryRequestDto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MiddleCategoryRequestVo {

    private String topCategoryName;
    private String middleCategoryName;

    public MiddleCategoryRequestDto toDto() {
        return MiddleCategoryRequestDto.builder()
                .topCategoryName(topCategoryName)
                .middleCategoryName(middleCategoryName)
                .build();
    }
}
