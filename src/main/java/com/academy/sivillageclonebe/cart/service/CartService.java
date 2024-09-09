package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.vo.CartRequestVo;

public interface CartService {

    public ProductsByCartDto addProductToCart(CartDto cartDto, ProductsByCartDto productsByCartDto);
}
