package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiddleCategoryRequestDto {

    private String middleCategoryName;
    private String topCategoryName;

    public MiddleCategory toEntity(TopCategory topCategory) {
        return MiddleCategory.builder()
                .categoryName(middleCategoryName)
                .topCategory(topCategory)
                .build();
    }

}
