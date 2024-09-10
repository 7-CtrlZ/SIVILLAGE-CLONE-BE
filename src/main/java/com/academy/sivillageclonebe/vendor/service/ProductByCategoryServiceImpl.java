package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;
import com.academy.sivillageclonebe.vendor.repository.ProductByCategoryRepository;
import com.academy.sivillageclonebe.vendor.repository.ProductByCategoryRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductByCategoryServiceImpl implements ProductByCategoryService{

    private final ProductByCategoryRepository productByCategoryRepository;
    private final ProductByCategoryRepositoryCustom productCategoryListRepositoryCustom;

    @Override
    public List<ProductByCategoryResponseDto> getProductCategoryListByCategories
            (String topCategoryCode, String middleCategoryCode, String bottomCategoryCode, String subCategoryCode) {

        return productCategoryListRepositoryCustom.getProductByCategoryListByCategories(
                topCategoryCode, middleCategoryCode, bottomCategoryCode, subCategoryCode).stream().map(
                productByCategory -> ProductByCategoryResponseDto.builder()
                        .productCode(productByCategory.getProductCode())
                        .build()
        ).toList();
    }
}
