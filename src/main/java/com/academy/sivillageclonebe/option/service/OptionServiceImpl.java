package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.repository.*;
import com.academy.sivillageclonebe.product.entity.ProductByOption;
import com.academy.sivillageclonebe.product.repository.ProductByOptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService{

    private final ProductColorsRepository productColorsRepository;
    private final ProductOptionsRepository productOptionsRepository;
    private final ProductSizesRepository productSizesRepository;
    private final ProductStatusRepository productStatusRepository;
    private final ProductStocksRepository productStocksRepository;
    private final ProductByOptionRepository productByOptionRepository;

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
    public void createProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        try {
            ProductByOption productByOption = productByOptionRepository.findById(
                    productStocksRequestDto.getProductByOptionId()).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
            );
            productStocksRepository.save(productStocksRequestDto.toEntity());

        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An unexpected error occurred: ", e);
            throw new RuntimeException("카테고리 생성 중 오류가 발생했습니다.", e);
        }
    }

}
