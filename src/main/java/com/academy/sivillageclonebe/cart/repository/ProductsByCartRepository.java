package com.academy.sivillageclonebe.cart.repository;

import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsByCartRepository extends JpaRepository<ProductsByCart, Long> {
    List<ProductsByCart> findByCart(Cart cart);
    int countByCartId(Long cartId);
}
