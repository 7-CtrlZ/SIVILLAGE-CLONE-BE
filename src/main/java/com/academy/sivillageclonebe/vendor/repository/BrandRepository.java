package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByBrandName(String brandName);
}
