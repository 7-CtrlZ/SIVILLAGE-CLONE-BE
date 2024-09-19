package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import com.academy.sivillageclonebe.vendor.entity.QProductByCategory;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductByCategoryRepositoryImpl implements ProductByCategoryRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductByCategory> getProductByCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName) {

        QProductByCategory productByCategory = QProductByCategory.productByCategory;
        BooleanBuilder builder = new BooleanBuilder();

        if (topCategoryName != null) {
            builder.and(productByCategory.topCategoryName.eq(topCategoryName));
        }
        if (middleCategoryName != null) {
            builder.and(productByCategory.middleCategoryName.eq(middleCategoryName));
        }
        if (bottomCategoryName != null) {
            builder.and(productByCategory.bottomCategoryName.eq(bottomCategoryName));
        }

        if (bottomCategoryName != null) {
            builder.and(productByCategory.subCategoryName.eq(subCategoryName));
        }

        return jpaQueryFactory.selectFrom(productByCategory)
                .where(builder)
                .fetch();
    }
}
