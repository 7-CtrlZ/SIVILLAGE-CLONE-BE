package com.academy.sivillageclonebe.vendor.dto;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByCategoryRequestDto {

    private String topCategoryName;
    private String middleCategoryName;
    private String bottomCategoryName;
    private String subCategoryName;
    private String productCode;

    public ProductByCategory toEntity() {
        return ProductByCategory.builder()
                .topCategoryName(topCategoryName)
                .middleCategoryName(middleCategoryName)
                .bottomCategoryName(bottomCategoryName)
                .subCategoryName(subCategoryName)
                .productCode(productCode)
                .build();
    }
}
