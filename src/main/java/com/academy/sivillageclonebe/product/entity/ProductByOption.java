package com.academy.sivillageclonebe.product.entity;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.option.entity.ProductColors;
import com.academy.sivillageclonebe.option.entity.ProductOptions;
import com.academy.sivillageclonebe.option.entity.ProductSizes;
import com.academy.sivillageclonebe.option.entity.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productSizeId", nullable = false)
    private ProductSizes productSizes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productOptionId", nullable = false)
    private ProductOptions productOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productStatusId", nullable = false)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productColorsId", nullable = false)
    private ProductColors productColors;
}
