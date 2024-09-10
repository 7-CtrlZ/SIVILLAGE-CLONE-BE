package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Optional<Brand> findById(Integer Id);

}
