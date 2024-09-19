package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
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
                .topCategoryCode(productByCategoryRequestVo.getTopCategoryCode())
                .middleCategoryCode(productByCategoryRequestVo.getMiddleCategoryCode())
                .bottomCategoryCode(productByCategoryRequestVo.getBottomCategoryCode())
                .subCategoryCode(productByCategoryRequestVo.getSubCategoryCode())
                .build();
        productByCategoryService.createCategoryProduct(productByCategoryRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }
    @GetMapping("/productCategoryList")
    public CommonResponseEntity<List<ProductByCategoryResponseVo>> getProductByCategoryList(
            @RequestParam( value = "topCategoryCode", required = false ) String topCategoryCode,
            @RequestParam( value = "middleCategoryCode", required = false ) String middleCategoryCode,
            @RequestParam( value = "bottomCategoryCode", required = false ) String bottomCategoryCode,
            @RequestParam( value = "subCategoryCode", required = false ) String subCategoryCode)
    {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                productByCategoryService.getProductCategoryListByCategories(
                        topCategoryCode, middleCategoryCode, bottomCategoryCode, subCategoryCode).stream().map(
                        ProductByCategoryResponseDto::toVo).toList());
    }
}
