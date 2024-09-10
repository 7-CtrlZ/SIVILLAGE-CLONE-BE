package com.academy.sivillageclonebe.product.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productUuid;
    private String productCode;
    private String productName;
    private Integer brandId;
    private String productDescription;
    private String productDetailContent;
    private Double price;
}
