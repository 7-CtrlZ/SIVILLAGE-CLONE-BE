package com.academy.sivillageclonebe.admin.controlloer;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.service.CategoryService;
import com.academy.sivillageclonebe.admin.vo.*;
import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
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
                .topCategoryName(middleCategoryRequestVo.getTopCategoryName())
                .middleCategoryName(middleCategoryRequestVo.getMiddleCategoryName())
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
                .middleCategoryName(bottomCategoryRequestVo.getMiddleCategoryName())
                .bottomCategoryName(bottomCategoryRequestVo.getBottomCategoryName())
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
                .bottomCategoryName(subCategoryRequestVo.getBottomCategoryName())
                .subCategoryName(subCategoryRequestVo.getSubCategoryName())
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
//      return categoryService.getTopCategoryList().stream().map(TopCategoryResponseDto::toVo).toList();
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                topCategoryResponseDtoList.stream().map(TopCategoryResponseDto::toVo).toList());
    }

    @GetMapping("topCategoryName/{topCategoryName}/middle-categoryList")
    public CommonResponseEntity<List<MiddleCategoryResponseVo>> getMiddleCategoryList(
            @PathVariable String topCategoryName) {
        List<MiddleCategoryResponseDto> middleCategoryResponseDtoList = categoryService.getMiddleCategoryListByTopCategoryName(topCategoryName);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                middleCategoryResponseDtoList.stream().map(MiddleCategoryResponseDto::toVo).toList());
    }

    @GetMapping("middleCategoryName/{middleCategoryName}/bottom-categoryList")
    public CommonResponseEntity<List<BottomCategoryResponseVo>> getBottomCategoryList(
            @PathVariable String middleCategoryName) {
        List<BottomCategoryResponseDto> bottomCategoryResponseDtoList = categoryService.getBottomCategoryListByMiddleCategoryName(middleCategoryName);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                bottomCategoryResponseDtoList.stream().map(BottomCategoryResponseDto::toVo).toList());
    }

    @GetMapping("bottomCategoryName/{bottomCategoryName}/sub-categoryList")
    public CommonResponseEntity<List<SubCategoryResponseVo>> getSubCategoryList(
            @PathVariable String bottomCategoryName) {
        List<SubCategoryResponseDto> subCategoryResponseDtoList = categoryService.getSubCategoryListByBottomCategoryName(bottomCategoryName);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                subCategoryResponseDtoList.stream().map(SubCategoryResponseDto::toVo).toList());
    }
}
