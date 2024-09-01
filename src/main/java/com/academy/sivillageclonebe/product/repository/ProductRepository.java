package com.academy.sivillageclonebe.product.repository;

import com.academy.sivillageclonebe.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductUuid(String productUuid);
}
