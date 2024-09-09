package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDto productDto) {
        String productUuid;
        String productCode;

        productUuid = UUID.randomUUID().toString();
        productCode = productUuid.substring(0, 8);

        productRepository.save(productDto.toEntity(productUuid, productCode));

    }

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        Product getProduct = productRepository.findByProductUuid(productUuid).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return ProductResponseDto.builder()
                .productUuid(getProduct.getProductUuid())
                .productCode(getProduct.getProductCode())
                .productName(getProduct.getProductName())
                .productDescription(getProduct.getProductDescription())
                .productDetailContent(getProduct.getProductDetailContent())
                .price(getProduct.getPrice())
                .build();
    }


//    @Override
//    public Integer getBrandIdByProductId(Long productId) {
//        // 예시: 실제 브랜드 ID를 찾는 로직을 구현
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
//
//        브랜드 아이디가...
//        return product.getBrandId();
//    }

}
