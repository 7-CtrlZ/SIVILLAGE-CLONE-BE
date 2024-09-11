package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductImages;
import com.academy.sivillageclonebe.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesRequestDto {

    private Long productId;
    private String imageUrl;
    private String imageDescription;
    private Boolean isMainImage;

    public ProductImages toEntity(Product product) {
        return ProductImages.builder()
                .imageUrl(imageUrl)
                .imageDescription(imageDescription)
                .isMainImage(isMainImage)
                .product(product)
                .build();
    }

}
