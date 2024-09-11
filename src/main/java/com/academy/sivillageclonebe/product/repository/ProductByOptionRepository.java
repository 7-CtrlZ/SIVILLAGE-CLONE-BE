package com.academy.sivillageclonebe.product.repository;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.product.entity.ProductByOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductByOptionRepository extends JpaRepository<ProductByOption, Long> {
}
