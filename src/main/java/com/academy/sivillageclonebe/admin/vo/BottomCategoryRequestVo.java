package com.academy.sivillageclonebe.admin.vo;

import com.academy.sivillageclonebe.admin.dto.BottomCategoryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottomCategoryRequestVo {

    private String middleCategoryName;
    private String bottomCategoryName;

    public BottomCategoryRequestDto toDto() {
        return BottomCategoryRequestDto.builder()
                .middleCategoryName(middleCategoryName)
                .bottomCategoryName(bottomCategoryName)
                .build();
    }
}