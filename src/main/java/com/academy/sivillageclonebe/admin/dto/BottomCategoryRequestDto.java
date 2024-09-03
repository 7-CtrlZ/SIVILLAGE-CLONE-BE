package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottomCategoryRequestDto {

    private String bottomCategoryName;
    private String middleCategoryCode;


}
