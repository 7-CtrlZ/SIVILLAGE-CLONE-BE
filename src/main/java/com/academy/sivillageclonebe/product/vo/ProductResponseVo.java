package com.academy.sivillageclonebe.product.vo;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productUuid;
    private String productCode;
    private Integer brandId;
    private String productName;
    private String productDescription;
    private String productDetailContent;
    private Double price;
}
