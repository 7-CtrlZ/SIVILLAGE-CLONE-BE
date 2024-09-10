package com.academy.sivillageclonebe.option.entity;


import com.academy.sivillageclonebe.product.entity.ProductByOption;
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
public class ProductStocks {

    @Id
    private Long productsByOptionId;

    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "productsByOptionId")
    private ProductByOption productByOption;
}
