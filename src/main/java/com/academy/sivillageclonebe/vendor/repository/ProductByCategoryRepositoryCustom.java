package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductByCategoryRepositoryCustom {

    List<ProductByCategory> getProductByCategoryListByCategories(
            String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, String subCategoryCode);

}
git commit -m "Feat: 카테고리 상품코드 리스트 조회, 상품 조회 기능 수정"