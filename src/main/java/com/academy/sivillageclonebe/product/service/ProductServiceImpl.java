package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseVo addProduct(ProductRequestDto productDto) {
        String productUuid;

        productUuid = UUID.randomUUID().toString();

        productRepository.save(productDto.toEntity(productUuid));

        return null;
    }

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        Product getProduct = productRepository.findByProductUuid(productUuid).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return ProductResponseDto.builder()
                .productUuid(getProduct.getProductUuid())
                .productName(getProduct.getProductName())
                .brandId(getProduct.getBrandId())
                .productDescription(getProduct.getProductDescription())
                .price(getProduct.getPrice())
                .build();
    }

}
