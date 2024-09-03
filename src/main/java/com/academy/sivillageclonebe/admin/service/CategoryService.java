package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.reponstity.BottomCategoryRepository;

public interface CategoryService {

    void createTopCategory(TopCategoryRequestDto topCategoryRequestDto);
    TopCategoryResponseDto getTopCategoryByCategoryCode(String topCategoryCode);

    void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto);
    MiddleCategoryResponseDto getMiddleCategoryByCode(String middleCategoryCode);

    void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto);

}
