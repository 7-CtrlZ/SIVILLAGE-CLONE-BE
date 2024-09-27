package com.academy.sivillageclonebe.vendor.vo;

import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ProductByCategoryRequestVo {

    private String productCode;
    private String topCategoryName;
    private String middleCategoryName;
    private String bottomCategoryName;
    private String subCategoryName;

    public ProductByCategoryRequestDto toDto() {
        return ProductByCategoryRequestDto.builder()
                .productCode(productCode)
                .topCategoryName(topCategoryName)
                .middleCategoryName(middleCategoryName)
                .bottomCategoryName(bottomCategoryName)
                .subCategoryName(subCategoryName)
                .build();
    }

}
