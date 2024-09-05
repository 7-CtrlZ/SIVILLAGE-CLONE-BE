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
import com.academy.sivillageclonebe.common.utills.CategoryCodeGenerator;
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

        String categoryCode = generateUniquesCategoryCode("TC-");
        try {
            topCategoryRepository.save(topCategoryRequestDto.toEntity(categoryCode));
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
            TopCategory topCategory = topCategoryRepository.findByCategoryCode(
                    middleCategoryRequestDto.getTopCategoryCode()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            String categoryCode = generateUniquesCategoryCode("MC-");
            middleCategoryRepository.save(middleCategoryRequestDto.toEntity(topCategory, categoryCode));
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
            MiddleCategory middleCategory = middleCategoryRepository.findByCategoryCode(
                    bottomCategoryRequestDto.getMiddleCategoryCode()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            String categoryCode = generateUniquesCategoryCode("BC-");
            bottomCategoryRepository.save(bottomCategoryRequestDto.toEntity(middleCategory, categoryCode));
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
            BottomCategory bottomCategory = bottomCategoryRepository.findByCategoryCode(
                    subCategoryRequestDto.getBottomCategoryCode()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            String categoryCode = generateUniquesCategoryCode("SC-");
            subCategoryRepository.save(subCategoryRequestDto.toEntity(bottomCategory, categoryCode));
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
                        .topCategoryCode(topCategory.getCategoryCode())
                        .build())
                .toList();
    }

    @Transactional
    @Override
    public List<MiddleCategoryResponseDto> getMiddleCategoryListByTopCategoryCode(String topCategoryCode) {
        List<MiddleCategory> middleCategoryList = middleCategoryRepository.findByTopCategoryCategoryCode(topCategoryCode);
        return middleCategoryList.stream()
                .map(middleCategory -> MiddleCategoryResponseDto.builder()
                        .middleCategoryName(middleCategory.getCategoryName())
                        .middleCategoryCode(middleCategory.getCategoryCode())
                        .topCategoryCode(middleCategory.getTopCategory().getCategoryCode())
                        .build())
                .toList();
    }

    @Transactional
    @Override
    public List<BottomCategoryResponseDto> getBottomCategoryListByMiddleCategoryCode(String middleCategoryCode) {
        List<BottomCategory> bottomCategoryList = bottomCategoryRepository.findByMiddleCategoryCategoryCode(middleCategoryCode);
        return bottomCategoryList.stream()
                .map(bottomCategory -> BottomCategoryResponseDto.builder()
                        .bottomCategoryCode(bottomCategory.getCategoryCode())
                        .bottomCategoryName(bottomCategory.getCategoryName())
                        .middleCategoryCode(bottomCategory.getMiddleCategory().getCategoryCode())
                        .build())
                .toList();
    }
    @Transactional
    @Override
    public List<SubCategoryResponseDto> getSubCategoryListByBottomCategoryCode(String bottomCategoryCode) {
        List<SubCategory> subCategoryList = subCategoryRepository.findByBottomCategoryCategoryCode(bottomCategoryCode);
        return subCategoryList.stream()
                .map(subCategory -> SubCategoryResponseDto.builder()
                        .subCategoryCode(subCategory.getCategoryCode())
                        .subCategoryName(subCategory.getCategoryName())
                        .bottomCategoryCode(subCategory.getBottomCategory().getCategoryCode())
                        .build())
                .toList();
    }

    public String generateUniquesCategoryCode(String prefix) {
        for (int i = 0; i < MAX_CODE_TRIES; i++) {
            String categoryCode = CategoryCodeGenerator.generateCategoryCode(prefix);
            switch (prefix) {
                case "TC-":
                    if (!topCategoryRepository.existsByCategoryCode(categoryCode)) {
                        return categoryCode;
                    }
                    break;
                case "MC-":
                    if (!middleCategoryRepository.existsByCategoryCode(categoryCode)) {
                        return categoryCode;
                    }
                    break;
                case "BC-":
                    if (!bottomCategoryRepository.existsByCategoryCode(categoryCode)) {
                        return categoryCode;
                    }
                    break;
                case "SC-":
                    if (!subCategoryRepository.existsByCategoryCode(categoryCode)) {
                        return categoryCode;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("유효하지 않은 카테고리 코드 접두사입니다: " + prefix);
            }

        }
        throw new IllegalStateException("고유한 카테고리 코드를 생성하는 데 실패했습니다.");

    }

}


