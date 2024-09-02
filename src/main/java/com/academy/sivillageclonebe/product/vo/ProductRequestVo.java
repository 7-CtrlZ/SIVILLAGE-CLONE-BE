package com.academy.sivillageclonebe.product.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductRequestVo {

    private Long brandId;
    private String productName;
    private String productDescription;
    private Double price;
}
