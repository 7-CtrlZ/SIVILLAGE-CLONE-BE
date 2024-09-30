package com.academy.sivillageclonebe.admin.controlloer;

import com.academy.sivillageclonebe.admin.dto.*;
import com.academy.sivillageclonebe.admin.service.CategoryService;
import com.academy.sivillageclonebe.admin.vo.*;
import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public BaseResponse<Void> creteTopCategory (
            @RequestBody TopCategoryRequestVo topCategoryRequestVo) {
        categoryService.createTopCategory(topCategoryRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "middleCategory 등록 API", description = "middleCategory 등록 API 입니다.", tags = {"Category"})
    @PostMapping("/middle-category")
    public BaseResponse<Void> createMiddleCategory (
            @RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {
        categoryService.createMiddleCategory(middleCategoryRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "bottomCategory 등록 API", description = "bottomCategory 등록 API 입니다.", tags = {"Category"})
    @PostMapping("/bottom-category")
    public BaseResponse<Void> createBottomCategory (
            @RequestBody BottomCategoryRequestVo bottomCategoryRequestVo) {
        categoryService.createBottomCategory(bottomCategoryRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "subCategory 등록 API", description = "subCategory 등록 API 입니다.", tags = {"Category"})
    @PostMapping("/sub-category")
    public BaseResponse<Void> createSubCategory (
            @RequestBody SubCategoryRequestVo subCategoryRequestVo) {
        categoryService.createSubCategory(subCategoryRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "topCategory 조회 API", description = "topCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("/top-categoryList")
    public BaseResponse<List<TopCategoryResponseVo>> getTopCategoryList() {
        return new BaseResponse<>(
                categoryService.getTopCategoryList()
                        .stream().map(TopCategoryResponseDto::toVo)
                        .toList());
    }

    @Operation(summary = "middleCategory 조회 API", description = "middleCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("topCategoryName/{topCategoryName}/middle-categoryList")
    public BaseResponse<List<MiddleCategoryResponseVo>> getMiddleCategoryList(
            @PathVariable String topCategoryName) {
        return new BaseResponse<>(
                categoryService.getMiddleCategoryListByTopCategoryName(topCategoryName)
                        .stream()
                        .map(MiddleCategoryResponseDto::toVo)
                        .toList());
    }

    @Operation(summary = "bottomCategory 조회 API", description = "bottomCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("middleCategoryName/{middleCategoryName}/bottom-categoryList")
    public BaseResponse<List<BottomCategoryResponseVo>> getBottomCategoryList(
            @PathVariable String middleCategoryName) {
        return new BaseResponse<>(
                categoryService.getBottomCategoryListByMiddleCategoryName(middleCategoryName)
                        .stream()
                        .map(BottomCategoryResponseDto::toVo)
                        .toList());
    }

    @Operation(summary = "subCategory 조회 API", description = "subCategory 조회 API 입니다.", tags = {"Category"})
    @GetMapping("bottomCategoryName/{bottomCategoryName}/sub-categoryList")
    public BaseResponse<List<SubCategoryResponseVo>> getSubCategoryList(
            @PathVariable String bottomCategoryName) {
        return new BaseResponse<>(
                categoryService.getSubCategoryListByBottomCategoryName(bottomCategoryName)
                        .stream()
                        .map(SubCategoryResponseDto::toVo)
                        .toList());
    }
}