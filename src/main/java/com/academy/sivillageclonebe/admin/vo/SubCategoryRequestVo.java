package com.academy.sivillageclonebe.admin.vo;

import com.academy.sivillageclonebe.admin.dto.SubCategoryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryRequestVo {

    private String bottomCategoryName;
    private String subCategoryName;

    public SubCategoryRequestDto toDto() {
        return SubCategoryRequestDto.builder()
                .bottomCategoryName(bottomCategoryName)
                .subCategoryName(subCategoryName)
                .build();
    }
}
