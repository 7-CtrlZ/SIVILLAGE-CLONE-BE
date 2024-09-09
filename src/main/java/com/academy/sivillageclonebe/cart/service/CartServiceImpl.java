package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import com.academy.sivillageclonebe.cart.repository.CartRepository;
import com.academy.sivillageclonebe.cart.repository.ProductsByCartRepository;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;
import com.academy.sivillageclonebe.product.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductsByCartRepository productsByCartRepository;
    private final ProductService productService;

    @Transactional
    public ProductsByCartDto addProductToCart(CartDto cartDto, ProductsByCartDto productsByCartDto) {
        // productsId로 브랜드 정보를 조회하는 로직
        Integer brandId = productService.getBrandIdByProductId(productsByCartDto.getProductsId());

        // memberId와 brandId로 Cart 조회, 없으면 새로 생성
        Cart cart = cartRepository.findByMemberIdAndBrandId(cartDto.getMemberId(), brandId)
                .orElseGet(() -> cartRepository.save(cartDto.toEntity()));

        // ProductsByCart 생성
        ProductsByCart productsByCart = productsByCartDto.toEntity(cart);

        ProductsByCart savedProductsByCart = productsByCartRepository.save(productsByCart);

        // 엔티티에서 DTO로 변환하여 반환
        return ProductsByCartDto.fromEntity(savedProductsByCart);
    }
}
