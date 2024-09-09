package com.academy.sivillageclonebe.product.service;

import com.academy.sivillageclonebe.admin.dto.SubCategoryResponseDto;
import com.academy.sivillageclonebe.admin.entity.SubCategory;
import com.academy.sivillageclonebe.product.dto.ProductByOptionDto;
import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import com.academy.sivillageclonebe.product.dto.ProductResponseDto;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.entity.ProductByOption;
import com.academy.sivillageclonebe.product.repository.ProductByOptionRepository;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import com.academy.sivillageclonebe.vendor.dto.ProductByCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductByOptionRepository productByOptionRepository;

    @Override
    public void addProduct(ProductRequestDto productDto) {
        String productUuid;
        String productCode;

        productUuid = UUID.randomUUID().toString();
        productCode = productUuid.substring(0, 8);

        productRepository.save(productDto.toEntity(productUuid, productCode));

    }

    @Override
    public ProductResponseDto getProduct(String productCode) {
        Product getProduct = productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        List<ProductByOption> productByOptionList = productByOptionRepository.findByProductId(getProduct.getId());
        List<ProductByOptionDto> productByOptionDtoList = productByOptionList.stream()
                .map(productByOption -> ProductByOptionDto.builder()
                        .sizeName(productByOption.getProductSizes().getSizeName())
                        .colorName(productByOption.getProductColors().getColorName())
                        .optionName(productByOption.getProductOptions().getOptionName())
                        .statusName(productByOption.getProductStatus().getStatuesName())
                        .build())
                .toList();

        return ProductResponseDto.builder()
                .productUuid(getProduct.getProductUuid())
                .productCode(getProduct.getProductCode())
                .brandName(getProduct.getBrandName())
                .productName(getProduct.getProductName())
                .productDescription(getProduct.getProductDescription())
                .productDetailContent(getProduct.getProductDetailContent())
                .price(getProduct.getPrice())
                .productByOptionDtoList(productByOptionDtoList)
                .build();
    }

}
