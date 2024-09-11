package com.academy.sivillageclonebe.option.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesResponseVo {

    private Long productId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;
}
