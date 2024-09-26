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

    @Operation(summary = "topCategory 등록 API", description = "topCategory 등록 API 입니다.", tags = {"Category"})
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

    @Operation(summary = "middleCategory 등록 API", description = "middleCategory 등록 API 입니다.", tags = {"Category"})
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

    @Operation(summary = "bottomCategory 등록 API", description = "bottomCategory 등록 API 입니다.", tags = {"Category"})
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

    @Operation(summary = "subCategory 등록 API", description = "subCategory 등록 API 입니다.", tags = {"Category"})
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

    @Operation(summary = "topCategory 조회 API", description = "topCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("/top-categoryList")
    public CommonResponseEntity<List<TopCategoryResponseVo>> getTopCategoryList() {
        List<TopCategoryResponseDto> topCategoryResponseDtoList = categoryService.getTopCategoryList();
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                topCategoryResponseDtoList.stream().map(TopCategoryResponseDto::toVo).toList());
    }

    @Operation(summary = "middleCategory 조회 API", description = "middleCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("topCategoryName/{topCategoryName}/middle-categoryList")
    public CommonResponseEntity<List<MiddleCategoryResponseVo>> getMiddleCategoryList(
            @PathVariable String topCategoryName) {
        List<MiddleCategoryResponseDto> middleCategoryResponseDtoList = categoryService.getMiddleCategoryListByTopCategoryName(topCategoryName);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                middleCategoryResponseDtoList.stream().map(MiddleCategoryResponseDto::toVo).toList());
    }

    @Operation(summary = "bottomCategory 조회 API", description = "bottomCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("middleCategoryName/{middleCategoryName}/bottom-categoryList")
    public CommonResponseEntity<List<BottomCategoryResponseVo>> getBottomCategoryList(
            @PathVariable String middleCategoryName) {
        List<BottomCategoryResponseDto> bottomCategoryResponseDtoList = categoryService.getBottomCategoryListByMiddleCategoryName(middleCategoryName);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                bottomCategoryResponseDtoList.stream().map(BottomCategoryResponseDto::toVo).toList());
    }
    @Operation(summary = "subCategory 조회 API", description = "subCategory 조회 API 입니다.", tags = {"Category"})
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
