package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartUpdateDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;

import java.util.List;

public interface ProductsByCartService {

    ProductsByCart saveProduct(ProductsByCart productsByCart);

    List<ProductsByCart> findByCart(Cart cart);

    void addProductToCart(CartDto cartDto, ProductsByCartDto productsByCartDto);

    void removeProductFromCart(Long productsByCartId);

    ProductsByCart save(ProductsByCart productsByCart);

    void updateCheck(Long productsByCartId);

    void updateOption(Long productsByCartId, ProductsByCartUpdateDto productsByCartUpdateDto);

}
