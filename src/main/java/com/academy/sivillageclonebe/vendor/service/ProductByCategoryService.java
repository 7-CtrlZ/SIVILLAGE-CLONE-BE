package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;

public interface ProductByCategoryService {

    CursorPage<ProductByCategoryResponseVo> getProductCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName, Integer page, Long lastId);
    void createCategoryProduct(ProductByCategoryRequestDto productByCategoryRequestDto);
}
