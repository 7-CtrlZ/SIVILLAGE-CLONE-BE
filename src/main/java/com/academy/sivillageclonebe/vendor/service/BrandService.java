package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.dto.BrandResponseDto;

public interface BrandService {

    void createBrand(BrandRequestDto brandRequestDto);
    BrandResponseDto getBrandById(Integer Id);
}
