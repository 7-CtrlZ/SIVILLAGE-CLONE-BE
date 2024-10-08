package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.option.dto.MainOptionResponseDto;
import com.academy.sivillageclonebe.option.repository.MainOptionRepository;
import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import com.academy.sivillageclonebe.vendor.entity.Brand;
import com.academy.sivillageclonebe.vendor.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final MainOptionRepository mainOptionRepository;

    @Override
    public void addProduct(ProductRequestDto productDto) {
        Brand brand = brandRepository.findById(productDto.getBrandId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BRAND));
        String productUuid;
        String productCode;

        productUuid = UUID.randomUUID().toString();
        productCode = productUuid.substring(0, 8);

        productRepository.save(productDto.toEntity(productUuid, productCode));
    }

    @Transactional(readOnly = true)
    @Override
    public ProductResponseDto getProduct(String productCode) {
        Product getProduct = productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));
        Brand brand = brandRepository.findById(getProduct.getBrandId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BRAND));

        List<MainOptionResponseDto> mainOptionList = mainOptionRepository.findByProduct_ProductCode(productCode)
                .stream()
                .map(MainOptionResponseDto::from)
                .toList();
        return ProductResponseDto.builder()
                .productCode(getProduct.getProductCode())
                .productName(getProduct.getProductName())
                .brandName(brand.getBrandName())
                .productDescription(getProduct.getProductDescription())
                .productDetailContent(getProduct.getProductDetailContent())
                .price(getProduct.getPrice())
                .mainOptionList(mainOptionList)
                .build();
    }

    @Override
    public Integer getBrandIdByProductCode(String productCode) {
        Product product = productRepository.findByProductCode(productCode).orElseThrow();
        return product.getBrandId();
    }

    @Override
    public Product findByProductId(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

}
