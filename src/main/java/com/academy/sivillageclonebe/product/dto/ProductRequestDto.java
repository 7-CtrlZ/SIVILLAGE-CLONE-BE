package com.academy.sivillageclonebe.product.dto;

import com.academy.sivillageclonebe.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductRequestDto {

    private String productUuid;
    private Long brandId;
    private String productName;
    private String productDescription;
    private Double price;

    public Product toEntity(String productUuid) {
        return Product.builder()
                .productUuid(productUuid)
                .brandId(brandId)
                .productName(productName)
                .productDescription(productDescription)
                .price(price)
                .build();
    }

    @Builder
    public ProductRequestDto(String productUuid, Long brandId, String productName, String productDescription, Double price) {
        this.productUuid = productUuid;
        this.brandId = brandId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

}
