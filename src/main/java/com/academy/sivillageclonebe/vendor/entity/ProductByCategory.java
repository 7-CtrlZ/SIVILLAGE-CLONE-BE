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
    private String topCategoryCode;
    @Column(nullable = false, length  = 100)
    private String middleCategoryCode;
    @Column(nullable = false, length  = 100)
    private String bottomCategoryCode;
    @Column(length  = 100)
    private String subCategoryCode;

    private String productCode;

}
