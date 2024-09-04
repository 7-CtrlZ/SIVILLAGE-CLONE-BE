package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.reponstity.BottomCategoryRepository;

import java.util.List;

public interface CategoryService {

    void createTopCategory(TopCategoryRequestDto topCategoryRequestDto);
    void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto);
    void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto);
    void createSubCategory(SubCategoryRequestDto subCategoryRequestDto);

    List<TopCategoryResponseDto> getTopCategoryList();
    List<MiddleCategoryResponseDto> getMiddleCategoryListByTopCategoryCode(String topCategoryCode);

}
