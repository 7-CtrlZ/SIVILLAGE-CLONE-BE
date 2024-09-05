package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;
import com.academy.sivillageclonebe.vendor.service.ProductByCategoryService;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vendor")
public class ProductByCategoryController {

    public final ProductByCategoryService productByCategoryService;

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
