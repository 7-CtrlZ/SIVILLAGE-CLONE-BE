package com.academy.sivillageclonebe.cart.controller;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.service.CartService;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;
import com.academy.sivillageclonebe.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductsByCartDto> addProductToCart(@RequestBody CartRequestVo cartRequestVo) {
        // VO에서 DTO로 변환
        CartDto cartDto = cartRequestVo.toDto(productService.getBrandIdByProductId(cartRequestVo.getProductsId()));
        ProductsByCartDto productsByCartDto = ProductsByCartDto.builder()
                .productsId(cartRequestVo.getProductsId())
                .productsByOptionId(cartRequestVo.getProductsByOptionId())
                .quantity(cartRequestVo.getQuantity())
                .isChecked(cartRequestVo.isChecked())
                .build();

        // DTO를 서비스 계층으로 전달
        ProductsByCartDto responseDto = cartService.addProductToCart(cartDto, productsByCartDto);
        return ResponseEntity.ok(responseDto);
    }
}
