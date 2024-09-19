package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
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
    public void createCategoryProduct(ProductByCategoryRequestDto productByCategoryRequestDto) {
        productByCategoryRepository.save(productByCategoryRequestDto.toEntity());
    }

    @Override
    public List<ProductByCategoryResponseDto> getProductCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName) {

        return productCategoryListRepositoryCustom.getProductByCategoryListByCategories(
                topCategoryName, middleCategoryName, bottomCategoryName, subCategoryName).stream().map(
                productByCategory -> ProductByCategoryResponseDto.builder()
                        .productCode(productByCategory.getProductCode())
                        .build()
        ).toList();
    }
}
