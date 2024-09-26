package com.academy.sivillageclonebe.cart.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductsByCartUpdateDto {
    private Long subOptionId;
    private Integer quantity;


}
