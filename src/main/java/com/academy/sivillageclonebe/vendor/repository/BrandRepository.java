package com.academy.sivillageclonebe.vendor.repository;

import com.academy.sivillageclonebe.vendor.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
