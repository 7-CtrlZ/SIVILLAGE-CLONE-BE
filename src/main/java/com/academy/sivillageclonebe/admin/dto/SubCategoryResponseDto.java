package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.SubCategory;
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
    private String bottomCategoryName;

    public SubCategoryResponseVo toVo() {
        return SubCategoryResponseVo.builder()
                .subCategoryName(subCategoryName)
                .bottomCategoryName(bottomCategoryName)
                .build();
    }

    public static SubCategoryResponseDto from(SubCategory subCategory) {
        return SubCategoryResponseDto.builder()
                .subCategoryName(subCategory.getCategoryName())
                .bottomCategoryName(subCategory.getBottomCategory().getCategoryName())
                .build();
    }
}
