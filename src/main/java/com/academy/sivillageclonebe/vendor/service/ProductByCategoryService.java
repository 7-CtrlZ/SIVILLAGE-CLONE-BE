package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;

import java.util.List;

public interface ProductByCategoryService {

    List<ProductByCategoryResponseDto> getProductCategoryListByCategories
            (String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, String subCategoryCode);
}
