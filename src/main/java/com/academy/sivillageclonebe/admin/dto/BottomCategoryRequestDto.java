package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottomCategoryRequestDto {

    private String bottomCategoryName;
    private String middleCategoryCode;

    public BottomCategory toEntity(MiddleCategory middleCategory, String bottomCategoryCode) {
        return BottomCategory.builder()
                .categoryName(bottomCategoryName)
                .categoryCode(bottomCategoryCode)
                .middleCategory(middleCategory)
                .build();
    }
}
