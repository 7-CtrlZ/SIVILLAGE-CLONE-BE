package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductByCategoryRepositoryCustom {

    List<ProductByCategory> getProductByCategoryListByCategories(
            String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, String subCategoryCode);

}