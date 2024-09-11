package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.ProductImagesResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesResponseDto {

    private Long productId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

    public ProductImagesResponseVo toVo() {
        return ProductImagesResponseVo.builder()
                .imageUrl(imageUrl)
                .imageDescription(imageDescription)
                .isMainImage(isMainImage)
                .productId(productId)
                .build();
    }
}
