package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;

public interface ProductService {

    void addProduct(ProductRequestDto productDto);

    Integer getBrandIdByProductCode(String productCode);

    ProductResponseDto getProduct(String productCode);

}
