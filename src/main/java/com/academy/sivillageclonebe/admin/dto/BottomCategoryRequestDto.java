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
    private String middleCategoryName;

    public BottomCategory toEntity(MiddleCategory middleCategory) {
        return BottomCategory.builder()
                .categoryName(bottomCategoryName)
                .middleCategory(middleCategory)
                .build();
    }
}
