package com.academy.sivillageclonebe.product.repository;

import com.academy.sivillageclonebe.product.entity.ProductByOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductByOptionRepository extends JpaRepository<ProductByOption, Long> {

    List<ProductByOption> findByProductId(Long productId);
}
