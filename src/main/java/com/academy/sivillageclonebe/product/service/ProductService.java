package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;

public interface ProductService {

    void addProduct(ProductRequestDto productDto);

    Integer getBrandIdByProductCode(String productCode);

    ProductResponseDto getProduct(String productCode);

    Product findByProductId(Long id);
}
