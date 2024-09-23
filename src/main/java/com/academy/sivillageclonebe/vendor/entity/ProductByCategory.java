package com.academy.sivillageclonebe.vendor.entity;

import com.academy.sivillageclonebe.product.entity.Product;
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
public class ProductByCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length  = 100)
    private String topCategoryName;
    @Column(nullable = false, length  = 100)
    private String middleCategoryName;
    @Column(nullable = false, length  = 100)
    private String bottomCategoryName;
    @Column(length  = 100)
    private String subCategoryName;

    private String productCode;

}
