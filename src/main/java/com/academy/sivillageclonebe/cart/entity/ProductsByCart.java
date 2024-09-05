package com.academy.sivillageclonebe.cart.entity;

import jakarta.persistence.*;

public class ProductsByCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(nullable = false)
    private Long productsByOptionId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private boolean isChecked;
    
}
