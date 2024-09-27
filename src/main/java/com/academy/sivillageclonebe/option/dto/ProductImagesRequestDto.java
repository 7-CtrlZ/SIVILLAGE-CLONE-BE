package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.entity.ProductImages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesRequestDto {

    private Long mainOptionId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

    public ProductImages toEntity(MainOption mainOption) {
        return ProductImages.builder()
                .imageUrl(imageUrl)
                .imageDescription(imageDescription)
                .isMainImage(isMainImage)
                .mainOption(mainOption)
                .build();
    }

}
