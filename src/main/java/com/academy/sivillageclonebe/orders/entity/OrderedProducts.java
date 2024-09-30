package com.academy.sivillageclonebe.orders.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class OrderedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private String orderedMainOption;
    @Column(nullable = false)
    private String orderedSubOption;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Integer quantity;

    @Builder
    public OrderedProducts(
            Orders orders,
            Long productId,
            String orderedMainOption,
            String orderedSubOption,
            Long price,
            Integer quantity
    ) {
        this.orders = orders;
        this.productId = productId;
        this.orderedMainOption = orderedMainOption;
        this.orderedSubOption = orderedSubOption;
        this.price = price;
        this.quantity = quantity;
    }
}
