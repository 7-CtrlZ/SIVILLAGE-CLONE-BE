package com.academy.sivillageclonebe.admin.vo;

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
}
