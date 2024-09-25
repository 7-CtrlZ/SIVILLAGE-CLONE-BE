package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;

import java.util.List;

public interface ProductByCategoryService {

    List<ProductByCategoryResponseDto> getProductCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName);
    void createCategoryProduct(ProductByCategoryRequestDto productByCategoryRequestDto);
}
