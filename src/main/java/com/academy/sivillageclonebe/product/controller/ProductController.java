package com.academy.sivillageclonebe.product.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.service.ProductService;
import com.academy.sivillageclonebe.product.vo.ProductRequestVo;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public CommonResponseEntity<Void> addProduct(
            @RequestBody ProductRequestVo productRequestVo) {
        log.info("productRequestVo : {}", productRequestVo);
        ProductRequestDto productRequestDto = ProductRequestDto.builder()
                .brandId(productRequestVo.getBrandId())
                .productName(productRequestVo.getProductName())
                .productDescription(productRequestVo.getProductDescription())
                .productDetailContent(productRequestVo.getProductDetailContent())
                .price(productRequestVo.getPrice())
                .build();
        productService.addProduct(productRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 등록 성공",
                null
        );
    }

    @GetMapping("/{productCode}")
    public CommonResponseEntity<ProductResponseVo> getProduct (@PathVariable String productCode) {
        ProductResponseDto productResponseDto = productService.getProduct(productCode);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 조회 성공",
                productResponseDto.toResponseVo()
        );
    }
}

