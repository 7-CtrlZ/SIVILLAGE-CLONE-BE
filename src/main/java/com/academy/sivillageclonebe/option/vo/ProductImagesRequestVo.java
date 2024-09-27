package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.dto.ProductImagesRequestDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductImagesRequestVo {

    private Long mainOptionId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

    public ProductImagesRequestDto toDto() {
        return ProductImagesRequestDto.builder()
                .mainOptionId(mainOptionId)
                .imageUrl(imageUrl)
                .imageDescription(imageDescription)
                .isMainImage(isMainImage)
                .build();
    }
}
