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
public class ProductStocks {

    @Id
    private Long subOptionId;
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "subOptionId")
    private SubOption subOption;
}
