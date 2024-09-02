package com.academy.sivillageclonebe.product.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productUuid;
    private Long brandId;
    private String productName;
    private String productDescription;
    private Double price;
}
