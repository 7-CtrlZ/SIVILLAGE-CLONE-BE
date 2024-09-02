package com.academy.sivillageclonebe.product.dto;

import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductResponseDto {

    private String productUuid;
    private Long brandId;
    private String productName;
    private String productDescription;
    private Double price;

    public ProductResponseVo toResponseVo() {
        return ProductResponseVo.builder()
                .productUuid(productUuid)
                .brandId(brandId)
                .productName(productName)
                .productDescription(productDescription)
                .price(price)
                .build();
    }

    public ProductResponseDto(String productUuid, Long brandId, String productName, String productDescription, Double price) {
        this.productUuid = productUuid;
        this.brandId = brandId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

}
