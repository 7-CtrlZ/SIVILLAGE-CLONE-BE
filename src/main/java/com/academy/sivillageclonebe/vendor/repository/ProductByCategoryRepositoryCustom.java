package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductByCategoryRepositoryCustom {

    CursorPage<ProductByCategoryResponseVo> getProductByCategoryListByCategories(
            String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName, Integer page, Long lastId);

}