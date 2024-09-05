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
            (String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, String subCategoryCode) {

        QProductByCategory productByCategory = QProductByCategory.productByCategory;
        BooleanBuilder builder = new BooleanBuilder();

        if (topCategoryCode != null) {
            builder.and(productByCategory.topCategoryCode.eq(topCategoryCode));
        }
        if (middleCategoryCode != null) {
            builder.and(productByCategory.middleCategoryCode.eq(middleCategoryCode));
        }
        if (bottomCategoryCode != null) {
            builder.and(productByCategory.bottomCategoryCode.eq(bottomCategoryCode));
        }

        if (bottomCategoryCode != null) {
            builder.and(productByCategory.subCategoryCode.eq(subCategoryCode));
        }

        return jpaQueryFactory.selectFrom(productByCategory)
                .where(builder)
                .fetch();
    }
}
