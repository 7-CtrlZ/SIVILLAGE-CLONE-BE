package com.academy.sivillageclonebe.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private Long brand_id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, length = 100)
    private String Description;
    @Column(nullable = false)
    private LocalDate created_at;
    @Column(nullable = false)
    private LocalDate updated_at;
}
