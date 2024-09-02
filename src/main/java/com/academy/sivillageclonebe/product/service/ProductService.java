package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;

public interface ProductService {

    Void addProduct(ProductRequestDto productDto);
    ProductResponseDto getProduct(String productUuid);
}
