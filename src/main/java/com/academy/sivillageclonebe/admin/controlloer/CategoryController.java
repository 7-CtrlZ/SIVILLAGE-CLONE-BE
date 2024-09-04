package com.academy.sivillageclonebe.admin.controlloer;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.service.CategoryService;
import com.academy.sivillageclonebe.admin.vo.*;
import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/category")
public class CategoryController {

    public final CategoryService categoryService;

    /*category create*/
    @PostMapping("/top-category")
    public CommonResponseEntity<Void> creteTopCategory (
            @RequestBody TopCategoryRequestVo topCategoryRequestVo) {
        log.info("TopCategoryRequestVo: {}", topCategoryRequestVo);
        TopCategoryRequestDto topCategoryRequestDto = TopCategoryRequestDto.builder()
                .topCategoryName(topCategoryRequestVo.getTopCategoryName())
                .build();
        categoryService.createTopCategory(topCategoryRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @PostMapping("/middle-category")
    public CommonResponseEntity<Void> createMiddleCategory (
            @RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {
        log.info("MiddleCategoryRequestVo: {}", middleCategoryRequestVo);
        MiddleCategoryRequestDto middleCategoryRequestDto = MiddleCategoryRequestDto.builder()
                .middleCategoryName(middleCategoryRequestVo.getMiddleCategoryName())
                .topCategoryCode(middleCategoryRequestVo.getTopCategoryCode())
                .build();
        categoryService.createMiddleCategory(middleCategoryRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @PostMapping("/bottom-category")
    public CommonResponseEntity<Void> createBottomCategory (
            @RequestBody BottomCategoryRequestVo bottomCategoryRequestVo) {
        log.info("BottomCategoryRequestVo: {}", bottomCategoryRequestVo);
        BottomCategoryRequestDto bottomCategoryRequestDto = BottomCategoryRequestDto.builder()
                .bottomCategoryName(bottomCategoryRequestVo.getBottomCategoryName())
                .middleCategoryCode(bottomCategoryRequestVo.getMiddleCategoryCode())
                .build();
        categoryService.createBottomCategory(bottomCategoryRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @PostMapping("/sub-category")
    public CommonResponseEntity<Void> createSubCategory (
            @RequestBody SubCategoryRequestVo subCategoryRequestVo) {
        log.info("SubCategoryRequestVo: {}", subCategoryRequestVo);
        SubCategoryRequestDto subCategoryRequestDto = SubCategoryRequestDto.builder()
                .subCategoryName(subCategoryRequestVo.getSubCategoryName())
                .bottomCategoryCode(subCategoryRequestVo.getBottomCategoryCode())
                .build();
        categoryService.createSubCategory(subCategoryRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @GetMapping("/top-categoryList")
    public CommonResponseEntity<List<TopCategoryResponseVo>> getTopCategoryList() {
        List<TopCategoryResponseDto> topCategoryResponseDtoList = categoryService.getTopCategoryList();
//       return categoryService.getTopCategoryList().stream().map(TopCategoryResponseDto::toVo).toList();
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                topCategoryResponseDtoList.stream().map(TopCategoryResponseDto::toVo).toList());
    }

    @GetMapping("/middle-categoryList/{topCategoryCode}")
    public CommonResponseEntity<List<MiddleCategoryResponseVo>> getMiddleCategoryList(
            @PathVariable String topCategoryCode) {
        List<MiddleCategoryResponseDto> middleCategoryResponseDtoList = categoryService.getMiddleCategoryListByTopCategoryCode(topCategoryCode);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                middleCategoryResponseDtoList.stream().map(MiddleCategoryResponseDto::toVo).toList());
    }

    @GetMapping("/bottom-categoryList/{middleCategoryCode}")
    public CommonResponseEntity<List<BottomCategoryResponseVo>> getBottomCategoryList(
            @PathVariable String middleCategoryCode) {
        List<BottomCategoryResponseDto> bottomCategoryResponseDtoList = categoryService.getBottomCategoryListByMiddleCategoryCode(middleCategoryCode);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                bottomCategoryResponseDtoList.stream().map(BottomCategoryResponseDto::toVo).toList());
    }

    @GetMapping("/sub-categoryList/{bottomCategoryCode}")
    public CommonResponseEntity<List<SubCategoryResponseVo>> getSubCategoryList(
            @PathVariable String bottomCategoryCode) {
        List<SubCategoryResponseDto> subCategoryResponseDtoList = categoryService.getSubCategoryListByBottomCategoryCode(bottomCategoryCode);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                subCategoryResponseDtoList.stream().map(SubCategoryResponseDto::toVo).toList());
    }


}
