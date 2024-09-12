package com.academy.sivillageclonebe.option.entity;

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
public class SubOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productOptionId", nullable = false)
    private ProductOptions productOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productStatusId", nullable = false)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainOptionId", nullable = false)
    private MainOption mainOption;

    @OneToOne(mappedBy = "subOption")
    private ProductStocks productStocks;

}
