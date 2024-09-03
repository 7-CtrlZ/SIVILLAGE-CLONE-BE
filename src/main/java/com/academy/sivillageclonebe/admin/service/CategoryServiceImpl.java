package com.academy.sivillageclonebe.admin.service;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.reponstity.BottomCategoryRepository;
import com.academy.sivillageclonebe.admin.reponstity.MiddleCategoryRepository;
import com.academy.sivillageclonebe.admin.reponstity.TopCategoryRepository;
import com.academy.sivillageclonebe.common.utills.CategoryCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;


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

    @Override
    public TopCategoryResponseDto getTopCategoryByCategoryCode(String topCategoryCode) {

        try {
            TopCategory topCategory = topCategoryRepository.findByCategoryCode(topCategoryCode)
                    .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
                    );
            log.info("topCategory : {}", topCategory);
            return TopCategoryResponseDto.builder()
                    .topCategoryCode(topCategory.getCategoryCode())
                    .topCategoryName(topCategory.getCategoryName())
                    .build();
        } catch (Exception e) {
            log.error("error : {}", e);
        }
        return null;
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

    @Override
    public MiddleCategoryResponseDto getMiddleCategoryByCode(String middleCategoryCode) {
        try {
            MiddleCategory middleCategory = middleCategoryRepository
                    .findByCategoryCode(middleCategoryCode)
                    .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
                    );
            log.info("middleCategory : {}", middleCategory);
            return MiddleCategoryResponseDto.builder()
                    .middleCategoryName(middleCategory.getCategoryName())
                    .middleCategoryCode(middleCategory.getCategoryCode())
                    .topCategoryCode(middleCategory.getTopCategory().getCategoryCode())
                    .build();

        } catch (Exception e) {
            log.error("error : {}", e);
        }
        return null;
    }

    @Override
    public void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto) {

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
                default:
                    throw new IllegalArgumentException("유효하지 않은 카테고리 코드 접두사입니다: " + prefix);
            }

        }
        throw new IllegalStateException("고유한 카테고리 코드를 생성하는 데 실패했습니다.");
        }
    }



