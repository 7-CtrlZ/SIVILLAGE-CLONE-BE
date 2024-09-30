package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.service.ProductByCategoryService;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryRequestVo;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vendor")
public class ProductByCategoryController {

    public final ProductByCategoryService productByCategoryService;

    @Operation(summary = "카테고리 별 상품 등록 API", description = "카테고리 별 상품 등록 API 입니다.", tags = {"Category"})
    @PostMapping("/CategoryProduct")
    public BaseResponse<Void> createCategoryProduct(
            @RequestBody ProductByCategoryRequestVo productByCategoryRequestVo) {
        productByCategoryService.createCategoryProduct(productByCategoryRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "카테고리 별 상품 조회 API", description = "카테고리 별 상품 조회 API 입니다.", tags = {"Category"})
    @GetMapping("/productCategoryList")
    public BaseResponse<CursorPage<ProductByCategoryResponseVo>> getProductCategoryListByCategories(
            @RequestParam( value = "topCategoryName", required = false ) String topCategoryName,
            @RequestParam( value = "middleCategoryName", required = false ) String middleCategoryName,
            @RequestParam( value = "bottomCategoryName", required = false ) String bottomCategoryName,
            @RequestParam( value = "subCategoryName", required = false ) String subCategoryName,
            @RequestParam( value = "lastId", defaultValue = "0" ) Long lastId,
            @RequestParam( value = "page", defaultValue = "0" ) Integer page)
    {
        return new BaseResponse<>(
                productByCategoryService.getProductCategoryListByCategories(
                        topCategoryName, middleCategoryName, bottomCategoryName, subCategoryName, page, lastId)
        );
    }
}
