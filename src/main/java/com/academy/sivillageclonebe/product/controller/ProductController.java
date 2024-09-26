package com.academy.sivillageclonebe.product.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.service.ProductService;
import com.academy.sivillageclonebe.product.vo.ProductRequestVo;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 등록 API", description = "상품 등록 API 입니다.", tags = {"Product"})
    @PostMapping
    public CommonResponseEntity<Void> addProduct(
            @RequestBody ProductRequestVo productRequestVo) {
            productService.addProduct(ProductRequestDto.from(productRequestVo));
            productService.addProduct(productRequestVo.toDto());
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @Operation(summary = "상품 조회 API", description = "productCode를 사용한 상품 조회 API 입니다.", tags = {"Product"})
    @GetMapping("/{productCode}")
    public CommonResponseEntity<ProductResponseVo> getProduct (@PathVariable String productCode) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                productService.getProduct(productCode).toVo()
        );
    }
}

