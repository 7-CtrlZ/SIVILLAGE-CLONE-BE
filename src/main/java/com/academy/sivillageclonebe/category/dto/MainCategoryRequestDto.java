package com.academy.sivillageclonebe.category.dto;

import com.academy.sivillageclonebe.category.entity.MainCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainCategoryRequestDto {

    private String categoryName;
//
//    public MainCategory toEntity(String categoryCode){
//
//    }
}
