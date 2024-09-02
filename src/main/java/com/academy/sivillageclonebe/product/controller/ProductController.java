package com.academy.sivillageclonebe.product.controller;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.service.ProductService;
import com.academy.sivillageclonebe.product.vo.ProductRequestVo;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> addProduct(
            @RequestBody ProductRequestVo productRequestVo) {
        log.info("productRequestVo : {}", productRequestVo);
        ProductRequestDto productRequestDto = ProductRequestDto.builder()
                .brandId(productRequestVo.getBrandId())
                .productName(productRequestVo.getProductName())
                .productDescription(productRequestVo.getProductDescription())
                .price(productRequestVo.getPrice())
                .build();
        Void productResponseVo = productService.addProduct(productRequestDto);
        return ResponseEntity.ok(productResponseVo);
    }

    @GetMapping("/{productUuid}")
    public ResponseEntity<ProductResponseVo> getProduct (@PathVariable String productUuid) {
        ProductResponseDto getProduct = productService.getProduct(productUuid);
        log.info("getProduct : {}", getProduct);
        ProductResponseVo productResponseVo = getProduct.toResponseVo();
        return ResponseEntity.ok(productResponseVo);
    }
}

