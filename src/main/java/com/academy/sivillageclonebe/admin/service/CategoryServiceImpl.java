package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.SubCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.repository.BottomCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.MiddleCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.SubCategoryRepository;
import com.academy.sivillageclonebe.admin.repository.TopCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;


    private static final int MAX_CODE_TRIES = 5;

    @Transactional
    @Override
    public void createTopCategory(TopCategoryRequestDto topCategoryRequestDto) {
        try {
            topCategoryRepository.save(topCategoryRequestDto.toEntity());
        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            throw new RuntimeException("카테고리 생성 중 오류가 발생했습니다.", e);
        }

    }

    @Transactional
    @Override
    public void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto) {

        try {
            TopCategory topCategory = topCategoryRepository.findByCategoryName(
                    middleCategoryRequestDto.getTopCategoryName()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            middleCategoryRepository.save(middleCategoryRequestDto.toEntity(topCategory));
        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            throw new RuntimeException("카테고리 생성 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional
    @Override
    public void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto) {
        try {
            MiddleCategory middleCategory = middleCategoryRepository.findByCategoryName(
                    bottomCategoryRequestDto.getMiddleCategoryName()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            bottomCategoryRepository.save(bottomCategoryRequestDto.toEntity(middleCategory));
        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            throw new RuntimeException("카테고리 생성 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional
    @Override
    public void createSubCategory(SubCategoryRequestDto subCategoryRequestDto) {
        try {
            BottomCategory bottomCategory = bottomCategoryRepository.findByCategoryName(
                    subCategoryRequestDto.getBottomCategoryName()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            subCategoryRepository.save(subCategoryRequestDto.toEntity(bottomCategory));
        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            throw new RuntimeException("카테고리 생성 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional
    @Override
    public List<TopCategoryResponseDto> getTopCategoryList() {
        List<TopCategory> topCategoryList = topCategoryRepository.findAll();
//        return topCategoryList.stream()
//                .map(TopCategoryResponseDto::toDto).toList();
        return topCategoryList.stream()
                .map(topCategory -> TopCategoryResponseDto.builder()
                        .topCategoryName(topCategory.getCategoryName())
                        .build())
                .toList();
    }

    @Transactional
    @Override
    public List<MiddleCategoryResponseDto> getMiddleCategoryListByTopCategoryName(String topCategoryName) {
        List<MiddleCategory> middleCategoryList = middleCategoryRepository.findByTopCategoryCategoryName(topCategoryName);
        return middleCategoryList.stream()
                .map(middleCategory -> MiddleCategoryResponseDto.builder()
                        .middleCategoryName(middleCategory.getCategoryName())
                        .topCategoryName(middleCategory.getTopCategory().getCategoryName())
                        .build())
                .toList();
    }

    @Transactional
    @Override
    public List<BottomCategoryResponseDto> getBottomCategoryListByMiddleCategoryName(String middleCategoryName) {
        List<BottomCategory> bottomCategoryList = bottomCategoryRepository.findByMiddleCategoryCategoryName(middleCategoryName);
        return bottomCategoryList.stream()
                .map(bottomCategory -> BottomCategoryResponseDto.builder()
                        .bottomCategoryName(bottomCategory.getCategoryName())
                        .middleCategoryName(bottomCategory.getMiddleCategory().getCategoryName())
                        .build())
                .toList();
    }
    @Transactional
    @Override
    public List<SubCategoryResponseDto> getSubCategoryListByBottomCategoryName(String bottomCategoryName) {
        List<SubCategory> subCategoryList = subCategoryRepository.findByBottomCategoryCategoryName(bottomCategoryName);
        return subCategoryList.stream()
                .map(subCategory -> SubCategoryResponseDto.builder()
                        .subCategoryName(subCategory.getCategoryName())
                        .bottomCategoryName(subCategory.getBottomCategory().getCategoryName())
                        .build())
                .toList();
    }

}


