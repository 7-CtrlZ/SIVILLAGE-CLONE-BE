package com.academy.sivillageclonebe.admin.vo;

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
}