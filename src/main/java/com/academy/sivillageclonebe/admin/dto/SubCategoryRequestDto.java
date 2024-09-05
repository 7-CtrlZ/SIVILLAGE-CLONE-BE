package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.SubCategory;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryRequestDto {

    private String subCategoryName;
    private String bottomCategoryCode;

    public SubCategory toEntity(BottomCategory bottomCategory, String subCategoryCode) {
        return SubCategory.builder()
                .categoryName(subCategoryName)
                .categoryCode(subCategoryCode)
                .bottomCategory(bottomCategory)
                .build();
    }
}
