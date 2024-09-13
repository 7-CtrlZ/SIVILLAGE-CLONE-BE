package com.academy.sivillageclonebe.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private String orderedColor;
    @Column(nullable = false)
    private String orderedOption;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Integer quantity;
}
