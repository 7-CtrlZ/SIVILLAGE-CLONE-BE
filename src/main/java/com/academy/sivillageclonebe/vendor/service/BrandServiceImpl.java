package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.dto.BrandResponseDto;
import com.academy.sivillageclonebe.vendor.entity.Brand;
import com.academy.sivillageclonebe.vendor.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;
    @Override
    public void createBrand(BrandRequestDto brandRequestDto) {
        brandRepository.save(brandRequestDto.toEntity());
    }

    @Override
    public BrandResponseDto getBrandById(Integer Id) {
        Brand getBrand = brandRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));
        return BrandResponseDto.builder()
                .brandName(getBrand.getBrandName())
                .build();
    }
}
