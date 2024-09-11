package com.academy.sivillageclonebe.option.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductImagesRequestVo {

    private Long productId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

}
