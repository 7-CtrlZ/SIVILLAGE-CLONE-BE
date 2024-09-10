package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;

import java.util.List;

public interface CartService {

    List<CartDto> findAllByMemberId(Long memberId);
}
