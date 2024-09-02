package com.academy.sivillageclonebe.admin.entity;

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
public class DetailedCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length  = 100)
    private String categoryName;

    @Column(nullable = false, length  = 100)
    private String categoryCode;


    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;

}
