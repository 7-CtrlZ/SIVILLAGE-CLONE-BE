package com.academy.sivillageclonebe.cart.repository;

import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsByCartRepository extends JpaRepository<ProductsByCart, Long> {
}
