package com.academy.sivillageclonebe.product.dto;

import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String productUuid;
    private String productCode;
    private String productName;
    private Double price;
    private String productDescription;
    private String productDetailContent;

    public ProductResponseVo toResponseVo() {
        return ProductResponseVo.builder()
                .productUuid(productUuid)
                .productCode(productCode)
                .productName(productName)
                .price(price)
                .productDescription(productDescription)
                .productDetailContent(productDetailContent)
                .build();
    }

}
