package com.academy.sivillageclonebe.vendor.service;

import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.dto.BrandResponseDto;
import com.academy.sivillageclonebe.vendor.entity.Brand;
import com.academy.sivillageclonebe.vendor.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    public void createBrand(BrandRequestDto brandRequestDto) {
        if (brandRepository.existsByBrandName(brandRequestDto.getBrandName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_BRAND);
        }
        brandRepository.save(brandRequestDto.toEntity());
    }

    @Override
    public BrandResponseDto getBrandById(Integer Id) {
        Brand getBrand = brandRepository.findById(Id)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BRAND));
        return BrandResponseDto.builder()
                .brandName(getBrand.getBrandName())
                .build();
    }
}
