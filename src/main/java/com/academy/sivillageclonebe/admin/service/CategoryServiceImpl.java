package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.repository.BottomCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.MiddleCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.SubCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.TopCategoryRepository;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Transactional
    @Override
    public void createTopCategory(TopCategoryRequestDto topCategoryRequestDto) {

        if (topCategoryRepository.existsByCategoryName(topCategoryRequestDto.getTopCategoryName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_CATEGORY);
        }
        topCategoryRepository.save(topCategoryRequestDto.toEntity());
    }

    @Transactional
    @Override
    public void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto) {

        if (middleCategoryRepository.existsByCategoryName(middleCategoryRequestDto.getMiddleCategoryName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_CATEGORY);
        }
            TopCategory topCategory = topCategoryRepository.findByCategoryName(
                    middleCategoryRequestDto.getTopCategoryName()).orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY)
            );
            middleCategoryRepository.save(middleCategoryRequestDto.toEntity(topCategory));
    }

    @Transactional
    @Override
    public void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto) {

        if ( bottomCategoryRepository.existsByCategoryName(bottomCategoryRequestDto.getBottomCategoryName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_CATEGORY);
        }
            MiddleCategory middleCategory = middleCategoryRepository.findByCategoryName(
                    bottomCategoryRequestDto.getMiddleCategoryName()).orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY)
            );
            bottomCategoryRepository.save(bottomCategoryRequestDto.toEntity(middleCategory));
    }

    @Transactional
    @Override
    public void createSubCategory(SubCategoryRequestDto subCategoryRequestDto) {

        if (subCategoryRepository.existsByCategoryName(subCategoryRequestDto.getSubCategoryName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_CATEGORY);
        }
            BottomCategory bottomCategory = bottomCategoryRepository.findByCategoryName(
                    subCategoryRequestDto.getBottomCategoryName()).orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY)
            );
            subCategoryRepository.save(subCategoryRequestDto.toEntity(bottomCategory));
    }

    @Transactional(readOnly = true)
    @Override
    public List<TopCategoryResponseDto> getTopCategoryList() {
        return  topCategoryRepository.findAll().stream()
                .map(TopCategoryResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<MiddleCategoryResponseDto> getMiddleCategoryListByTopCategoryName(String topCategoryName) {
        TopCategory topCategory = topCategoryRepository.findByCategoryName(topCategoryName)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        return  middleCategoryRepository.findByTopCategoryCategoryName(topCategoryName)
                .stream()
                .map(MiddleCategoryResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<BottomCategoryResponseDto> getBottomCategoryListByMiddleCategoryName(String middleCategoryName) {
        MiddleCategory middleCategory = middleCategoryRepository.findByCategoryName(middleCategoryName)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        return bottomCategoryRepository.findByMiddleCategoryCategoryName(middleCategoryName)
                .stream()
                .map(BottomCategoryResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubCategoryResponseDto> getSubCategoryListByBottomCategoryName(String bottomCategoryName) {
        BottomCategory bottomCategory = bottomCategoryRepository.findByCategoryName(bottomCategoryName)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        return subCategoryRepository.findByBottomCategoryCategoryName(bottomCategoryName)
                .stream()
                .map(SubCategoryResponseDto::from)
                .toList();
    }
}


