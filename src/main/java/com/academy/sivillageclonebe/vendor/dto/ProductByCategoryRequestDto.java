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

    private String topCategoryCode;
    private String middleCategoryCode;
    private String bottomCategoryCode;
    private String subCategoryCode;
    private String productCode;

    public ProductByCategory toEntity() {
        return ProductByCategory.builder()
                .topCategoryCode(topCategoryCode)
                .middleCategoryCode(middleCategoryCode)
                .bottomCategoryCode(bottomCategoryCode)
                .subCategoryCode(subCategoryCode)
                .productCode(productCode)
                .build();
    }
}
