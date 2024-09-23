package com.academy.sivillageclonebe.vendor.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByCategoryRequestVo {

    private String topCategoryName;
    private String middleCategoryName;
    private String bottomCategoryName;
    private String subCategoryName;
    private String productCode;

}
