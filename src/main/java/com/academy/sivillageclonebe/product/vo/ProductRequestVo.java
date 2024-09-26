package com.academy.sivillageclonebe.product.vo;

import com.academy.sivillageclonebe.product.dto.ProductRequestDto;
import lombok.Getter;

@Getter
public class ProductRequestVo {

    private Integer brandId;
    private String productName;
    private Long price;
    private String productDescription;
    private String productDetailContent;

    public ProductRequestDto toDto() {
        return ProductRequestDto.builder()
                .brandId(brandId)
                .productName(productName)
                .price(price)
                .productDescription(productDescription)
                .productDetailContent(productDetailContent)
                .build();
    }

}




