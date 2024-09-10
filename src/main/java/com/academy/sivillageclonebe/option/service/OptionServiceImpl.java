package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.entity.Brand;
import com.academy.sivillageclonebe.option.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService{

    private final ProductColorsRepository productColorsRepository;
    private final ProductOptionsRepository productOptionsRepository;
    private final ProductSizesRepository productSizesRepository;
    private final ProductStatusRepository productStatusRepository;
    private final BrandRepository brandRepository;

    @Override
    public void createProductColors(ProductColorsRequestDto productColorsRequestDto) {
        productColorsRepository.save(productColorsRequestDto.toEntity());
    }

    @Override
    public void createProductOptions(ProductOptionsRequestDto productOptionsRequestDto) {
        productOptionsRepository.save(productOptionsRequestDto.toEntity());
    }

    @Override
    public void createProductSizes(ProductSizesRequestDto productSizesRequestDto) {
        productSizesRepository.save(productSizesRequestDto.toEntity());
    }

    @Override
    public void createProductStatus(ProductStatusRequestDto productStatusRequestDto) {
        productStatusRepository.save(productStatusRequestDto.toEntity());
    }


    @Override
    public void createBrand(BrandRequestDto brandRequestDto) {
        brandRepository.save(brandRequestDto.toEntity());
    }

    @Override
    public BrandResponseDto getBrandNameById(Integer Id) {
        Brand getBrand = brandRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));
        return BrandResponseDto.builder()
                .brandName(getBrand.getBrandName())
                .build();
    }
}
