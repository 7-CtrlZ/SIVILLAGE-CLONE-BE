package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

    List<ProductImages> findByMainOptionId(Long mainOptionId);

}
