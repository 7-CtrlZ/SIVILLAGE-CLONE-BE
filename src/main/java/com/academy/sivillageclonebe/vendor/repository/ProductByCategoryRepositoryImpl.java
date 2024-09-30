package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import com.academy.sivillageclonebe.vendor.entity.QProductByCategory;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductByCategoryRepositoryImpl implements ProductByCategoryRepositoryCustom {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_NUMBER = 0;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public CursorPage<ProductByCategoryResponseVo> getProductByCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName, Integer page, Long lastId) {

        QProductByCategory productByCategory = QProductByCategory.productByCategory;
        BooleanBuilder builder = new BooleanBuilder();

        Optional.ofNullable(topCategoryName)
                .ifPresent(code -> builder.and(productByCategory.topCategoryName.eq(topCategoryName)));
        Optional.ofNullable(middleCategoryName)
                .ifPresent(code -> builder.and(productByCategory.middleCategoryName.eq(middleCategoryName)));
        Optional.ofNullable(bottomCategoryName)
                .ifPresent(code -> builder.and(productByCategory.bottomCategoryName.eq(bottomCategoryName)));
        Optional.ofNullable(subCategoryName)
                .ifPresent(code -> builder.and(productByCategory.subCategoryName.eq(subCategoryName)));

        // 페이지와 페이지 크기 기본값 설정
        int currentPageSize = DEFAULT_PAGE_SIZE;
        int offset = 0;

        // lastId가 존재할 경우 lastId 기반 페이지네이션 우선 적용
        if (lastId != null) {
            builder.and(productByCategory.id.gt(lastId));
        } else {
            // lastId가 없을 경우 페이지네이션 처리
            int currentPage = Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER);
            offset = currentPage == 0 ? 0 : (currentPage - 1) * currentPageSize;
        }

        List<ProductByCategory> content = jpaQueryFactory
                .selectFrom(productByCategory)
                .where(builder)
                .orderBy(productByCategory.id.asc())
                .offset(offset)
                .limit(currentPageSize + 1)
                .fetch();

        Long nextCursor = null;
        boolean hasNext = false;

        if (content.size() > currentPageSize) {
            hasNext = true;
            content = content.subList(0, currentPageSize);
            nextCursor = content.get(content.size() - 1).getId();
        }

        List<ProductByCategoryResponseVo> productCodeList = content.stream()
                .map(product -> new ProductByCategoryResponseVo(product.getProductCode()))
                .toList();

        return new CursorPage<>(productCodeList, nextCursor, hasNext, currentPageSize, Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER));
    }
}
