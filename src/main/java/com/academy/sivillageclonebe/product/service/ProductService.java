package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;

public interface ProductService {

    void addProduct(ProductRequestDto productDto);

    Integer getBrandIdByProductId(Long productsId);

    ProductResponseDto getProduct(String productCode);

}
