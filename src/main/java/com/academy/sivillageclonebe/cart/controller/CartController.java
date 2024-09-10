package com.academy.sivillageclonebe.cart.controller;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.service.CartService;
import com.academy.sivillageclonebe.cart.service.ProductsByCartService;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;
import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.member.dto.MemberAddressDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.product.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final SecurityUtils securityUtils;
    private final ProductsByCartService productsByCartService;

    @PostMapping("/add")
    public CommonResponseEntity<ProductsByCartDto> addProductToCart(@RequestBody CartRequestVo cartRequestVo) {

        Member member = securityUtils.getAuthenticatedMember();
        CartDto cartDto = cartRequestVo.toDto(member.getId(), productService.getBrandIdByProductId(cartRequestVo.getProductsId()));
        ProductsByCartDto productsByCartDto = cartRequestVo.toProductsByCartDto();

        ProductsByCartDto responseDto = productsByCartService.addProductToCart(cartDto, productsByCartDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                responseDto
        );
    }

    @GetMapping
    public CommonResponseEntity<List<CartDto>> getAllCart() {
        Member member = securityUtils.getAuthenticatedMember();
        List<CartDto> carts = cartService.findAllByMemberId(member.getId());

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                carts
        );
    }

    @DeleteMapping("/{id}")
    public CommonResponseEntity<Void> deleteProductsByCart(@PathVariable Long id) {

        productsByCartService.removeProductFromCart(id);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

}
