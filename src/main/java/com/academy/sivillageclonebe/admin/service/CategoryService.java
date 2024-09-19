package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;

import java.util.List;

public interface CategoryService {

    void createTopCategory(TopCategoryRequestDto topCategoryRequestDto);
    void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto);
    void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto);
    void createSubCategory(SubCategoryRequestDto subCategoryRequestDto);

    List<TopCategoryResponseDto> getTopCategoryList();
    List<MiddleCategoryResponseDto> getMiddleCategoryListByTopCategoryName(String topCategoryName);
    List<BottomCategoryResponseDto> getBottomCategoryListByMiddleCategoryName(String middleCategoryName);
    List<SubCategoryResponseDto> getSubCategoryListByBottomCategoryName(String bottomCategoryName);

}
