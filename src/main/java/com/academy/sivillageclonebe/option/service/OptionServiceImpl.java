package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.entity.*;
import com.academy.sivillageclonebe.option.repository.*;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService {

    private final ProductOptionsRepository productOptionsRepository;
    private final ProductStatusRepository productStatusRepository;
    private final ProductStocksRepository productStocksRepository;
    private final ProductImagesRepository productImagesRepository;
    private final MainOptionRepository mainOptionRepository;
    private final SubOptionRepository subOptionRepository;
    private final ProductRepository productRepository;

    @Override
    public void createMainOptions(MainOptionRequestDto mainOptionRequestDto) {
        Product product = productRepository.findById(mainOptionRequestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
                );
        mainOptionRepository.save(mainOptionRequestDto.toEntity(product));
    }

    @Override
    public void createSubOptions(SubOptionRequestDto subOptionRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(subOptionRequestDto.getMainOptionId())
                .orElseThrow(() -> new RuntimeException("해당 메인 옵션이 없습니다."));

        ProductOptions productOptions = productOptionsRepository.findById(subOptionRequestDto.getProductOptionId())
                .orElseThrow(() -> new RuntimeException("해당 상품 옵션이 없습니다."));

        ProductStatus productStatus = productStatusRepository.findById(subOptionRequestDto.getProductStatusId())
                .orElseThrow(() -> new RuntimeException("해당 상품 상태가 없습니다."));
        subOptionRepository.save(subOptionRequestDto.toEntity(mainOption, productOptions, productStatus));
    }

    @Override
    public void createProductOptions(ProductOptionsRequestDto productOptionsRequestDto) {
        productOptionsRepository.save(productOptionsRequestDto.toEntity());
    }

    @Override
    public void createProductStatus(ProductStatusRequestDto productStatusRequestDto) {
        productStatusRepository.save(productStatusRequestDto.toEntity());
    }

    @Override
    public void createProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        SubOption subOption = subOptionRepository.findById(
                        productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다.")
                );
        productStocksRepository.save(productStocksRequestDto.toEntity());
    }

    @Override
    public void createProductImages(ProductImagesRequestDto productImagesRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(productImagesRequestDto.getMainOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다.")
                );
        productImagesRepository.save(productImagesRequestDto.toEntity(mainOption));
    }

    @Override
    public List<MainOptionResponseDto> getMainOptionListByProductId(Long productId) {
        List<MainOption> mainOptionList = mainOptionRepository.findByProductId(productId);
        return mainOptionList.stream().map(mainOption -> MainOptionResponseDto.builder()
                .mainOptionName(mainOption.getMainOptionName())
                .productId(mainOption.getProduct().getId())
                .build())
        .toList();
    }

    @Override
    public List<ProductImagesResponseDto> getProductImageListByMainOptionId(Long mainOptionId) {

        List<ProductImages> productImagesList = productImagesRepository.findByMainOptionId(mainOptionId);
        return productImagesList.stream().map(productImages -> ProductImagesResponseDto.builder()
                        .isMainImage(productImages.getIsMainImage())
                        .imageDescription(productImages.getImageDescription())
                        .imageUrl(productImages.getImageUrl())
                        .mainOptionId(productImages.getMainOption().getId())
                        .build())
                .toList();
    }

}
