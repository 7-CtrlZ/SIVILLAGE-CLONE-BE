package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.common.utills.CursorPage;
import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryRequestDto;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;
import com.academy.sivillageclonebe.vendor.service.ProductByCategoryService;
import com.academy.sivillageclonebe.vendor.vo.BrandRequestVo;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryRequestVo;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vendor")
public class ProductByCategoryController {

    public final ProductByCategoryService productByCategoryService;

    @PostMapping("/CategoryProduct")
    public CommonResponseEntity<Void> createCategoryProduct(
            @RequestBody ProductByCategoryRequestVo productByCategoryRequestVo) {
        log.info("ProductByCategoryRequestVo: {}", productByCategoryRequestVo);
        ProductByCategoryRequestDto productByCategoryRequestDto = ProductByCategoryRequestDto.builder()
                .productCode(productByCategoryRequestVo.getProductCode())
                .topCategoryName(productByCategoryRequestVo.getTopCategoryName())
                .middleCategoryName(productByCategoryRequestVo.getMiddleCategoryName())
                .bottomCategoryName(productByCategoryRequestVo.getBottomCategoryName())
                .subCategoryName(productByCategoryRequestVo.getSubCategoryName())
                .build();
        productByCategoryService.createCategoryProduct(productByCategoryRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @GetMapping("/productCategoryList")
    public CommonResponseEntity<CursorPage<ProductByCategoryResponseVo>> getProductCategoryListByCategories(
            @RequestParam( value = "topCategoryName", required = false ) String topCategoryName,
            @RequestParam( value = "middleCategoryName", required = false ) String middleCategoryName,
            @RequestParam( value = "bottomCategoryName", required = false ) String bottomCategoryName,
            @RequestParam( value = "subCategoryName", required = false ) String subCategoryName,
            @RequestParam( value = "lastId", defaultValue = "0" ) Long lastId,
            @RequestParam( value = "page", defaultValue = "0" ) Integer page)

    {
        CursorPage<ProductByCategoryResponseVo> cursorPage = productByCategoryService.getProductCategoryListByCategories(
                topCategoryName, middleCategoryName, bottomCategoryName, subCategoryName, page, lastId);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                cursorPage
        );
    }
}
