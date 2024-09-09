package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.ProductColorsRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductOptionsRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductSizesRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductStatusRequestDto;
import com.academy.sivillageclonebe.option.repository.ProductColorsRepository;
import com.academy.sivillageclonebe.option.repository.ProductOptionsRepository;
import com.academy.sivillageclonebe.option.repository.ProductSizesRepository;
import com.academy.sivillageclonebe.option.repository.ProductStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService{

    private final ProductColorsRepository productColorsRepository;
    private final ProductOptionsRepository productOptionsRepository;
    private final ProductSizesRepository productSizesRepository;
    private final ProductStatusRepository productStatusRepository;


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
}
