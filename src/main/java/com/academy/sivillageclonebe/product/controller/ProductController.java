package com.academy.sivillageclonebe.product.controller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.product.service.ProductService;
import com.academy.sivillageclonebe.product.vo.ProductRequestVo;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 등록 API", description = "상품 등록 API 입니다.", tags = {"Product"})
    @PostMapping
    public BaseResponse<Void> addProduct(
            @RequestBody ProductRequestVo productRequestVo) {
            productService.addProduct(productRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "상품 조회 API", description = "productCode를 사용한 상품 조회 API 입니다.", tags = {"Product"})
    @GetMapping("/{productCode}")
    public BaseResponse<ProductResponseVo> getProduct (@PathVariable String productCode) {
        return new BaseResponse<>(productService.getProduct(productCode).toVo()
        );
    }
}

