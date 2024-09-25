package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductByCategoryRepositoryCustom {

    List<ProductByCategory> getProductByCategoryListByCategories(
            String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName);

}