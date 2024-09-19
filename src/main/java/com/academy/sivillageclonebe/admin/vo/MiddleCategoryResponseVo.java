package com.academy.sivillageclonebe.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiddleCategoryResponseVo {

    private String topCategoryName;
    private String middleCategoryName;
}
