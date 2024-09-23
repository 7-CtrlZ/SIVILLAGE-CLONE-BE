package com.academy.sivillageclonebe.cart.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class ProductsByCart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(nullable = false)
    private String productCode;

    @Column(nullable = false)
    private Long subOptionId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private boolean isChecked;


    @Builder
    public ProductsByCart(
            Cart cart,
            String productCode,
            Long subOptionId,
            Integer quantity,
            boolean isChecked
    ) {
        this.cart = cart;
        this.productCode = productCode;
        this.subOptionId = subOptionId;
        this.quantity = quantity;
        this.isChecked = isChecked;
    }
}
