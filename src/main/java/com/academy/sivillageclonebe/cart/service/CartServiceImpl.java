package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import com.academy.sivillageclonebe.cart.repository.CartRepository;
import com.academy.sivillageclonebe.cart.repository.ProductsByCartRepository;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import com.academy.sivillageclonebe.product.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductsByCartService productsByCartService;

    @Override
    public List<CartDto> findAllByMemberId(Long memberId) {
        List<Cart> carts = cartRepository.findAllByMemberId(memberId);

        List<CartDto> cartDtos = carts.stream().map(cart -> {
            List<ProductsByCart> productsByCartList = productsByCartService.findByCart(cart);
            return CartDto.fromEntity(cart, productsByCartList);
        }).collect(Collectors.toList());

        return cartDtos;
    }
}
