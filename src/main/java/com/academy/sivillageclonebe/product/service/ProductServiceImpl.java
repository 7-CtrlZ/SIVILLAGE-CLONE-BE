package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public ProductResponseDto getProduct(String productCode) {
        Product getProduct = productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        return ProductResponseDto.builder()
                .productUuid(getProduct.getProductUuid())
                .productCode(getProduct.getProductCode())
                .brandId(getProduct.getBrandId())
                .productName(getProduct.getProductName())
                .brandId(getProduct.getBrandId())
                .productDescription(getProduct.getProductDescription())
                .productDetailContent(getProduct.getProductDetailContent())
                .price(getProduct.getPrice())
                .build();
    }

    @Override
    public Integer getBrandIdByProductId(Long productsId) {
        Product product = productRepository.findById(productsId).orElseThrow();
        return product.getBrandId();
    }

}
