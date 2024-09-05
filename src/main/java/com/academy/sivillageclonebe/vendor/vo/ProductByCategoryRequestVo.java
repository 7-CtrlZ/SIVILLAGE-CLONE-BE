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

    private String topCategoryCode;
    private String middleCategoryCode;
    private String bottomCategoryCode;
    private String subCategoryCode;
    private String productCode;

}
