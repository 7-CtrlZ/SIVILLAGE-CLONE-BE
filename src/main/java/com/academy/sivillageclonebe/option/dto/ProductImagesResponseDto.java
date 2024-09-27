package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductImages;
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

    private Long mainOptionId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

    public ProductImagesResponseVo toVo() {
        return ProductImagesResponseVo.builder()
                .imageUrl(imageUrl)
                .imageDescription(imageDescription)
                .isMainImage(isMainImage)
                .mainOptionId(mainOptionId)
                .build();
    }

    public static ProductImagesResponseDto from(ProductImages productImages) {
        return ProductImagesResponseDto.builder()
                .mainOptionId(productImages.getId())
                .imageUrl(productImages.getImageUrl())
                .imageDescription(productImages.getImageDescription())
                .isMainImage(productImages.getIsMainImage())
                .build();
    }
}
