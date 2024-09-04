package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.vo.MiddleCategoryResponseVo;
import com.academy.sivillageclonebe.admin.vo.SubCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponseDto {

    private String subCategoryName;
    private String subCategoryCode;
    private String bottomCategoryCode;

    public SubCategoryResponseVo toVo() {
        return SubCategoryResponseVo.builder()
                .subCategoryName(subCategoryName)
                .subCategoryCode(subCategoryCode)
                .bottomCategoryCode(bottomCategoryCode)
                .build();
    }
}
