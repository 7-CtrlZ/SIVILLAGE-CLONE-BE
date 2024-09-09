package com.academy.sivillageclonebe.product.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length  = 100)
    private String productUuid;

    @Column(nullable = false, length  = 100)
    private String productCode;

    @Column(nullable = false, length  = 100)
    private String brandName;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 500)
    private String productDescription;

    @Column(nullable = false, length  = 1000)
    private String productDetailContent;

}
