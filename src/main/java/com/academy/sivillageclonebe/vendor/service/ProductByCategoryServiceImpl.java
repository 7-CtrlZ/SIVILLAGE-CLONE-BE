package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
import com.academy.sivillageclonebe.vendor.repository.ProductByCategoryRepository;
import com.academy.sivillageclonebe.vendor.repository.ProductByCategoryRepositoryCustom;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public CursorPage<ProductByCategoryResponseVo> getProductCategoryListByCategories
            (String topCategoryName, String middleCategoryName, String bottomCategoryName, String subCategoryName, Integer page, Long lastId) {
        return productCategoryListRepositoryCustom.getProductByCategoryListByCategories
                (topCategoryName,middleCategoryName,bottomCategoryName,subCategoryName, page, lastId);
    }

}