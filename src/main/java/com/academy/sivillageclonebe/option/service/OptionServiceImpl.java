package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.entity.*;
import com.academy.sivillageclonebe.option.repository.*;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class OptionServiceImpl implements OptionService {

    private final ProductStocksRepository productStocksRepository;
    private final ProductImagesRepository productImagesRepository;
    private final MainOptionRepository mainOptionRepository;
    private final SubOptionRepository subOptionRepository;
    private final ProductRepository productRepository;

    @Override
    public void createMainOptions(MainOptionRequestDto mainOptionRequestDto) {
        Product product = productRepository.findByProductCode(mainOptionRequestDto.getProductCode())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));
        if (mainOptionRepository.existsByMainOptionNameAndProduct_ProductCode(
                mainOptionRequestDto.getMainOptionName(),
                product.getProductCode())) {
            throw new BaseException((BaseResponseStatus.DUPLICATED_OPTION));
        }
        mainOptionRepository.save(mainOptionRequestDto.toEntity(product));
    }

    @Override
    public void createSubOptions(SubOptionRequestDto subOptionRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(subOptionRequestDto.getMainOptionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        if (subOptionRepository.existsBySubOptionNameAndMainOptionId(
                subOptionRequestDto.getSubOptionName(),
                mainOption.getId())) {
            throw new BaseException((BaseResponseStatus.DUPLICATED_OPTION));
        }
        subOptionRepository.save(subOptionRequestDto.toEntity(mainOption));
    }

    @Override
    public void createProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        SubOption subOption = subOptionRepository.findById(
                        productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        productStocksRepository.save(productStocksRequestDto.toEntity(subOption, productStocksRequestDto.getOrderQuantity()));
    }

    @Override
    public void createProductImages(ProductImagesRequestDto productImagesRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(productImagesRequestDto.getMainOptionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        productImagesRepository.save(productImagesRequestDto.toEntity(mainOption));
    }

    @Override
    public void updateProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        SubOption subOption = subOptionRepository.findById(productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        ProductStocks productStocks = productStocksRepository.findBySubOptionId(productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_STOCKS_IN_OPTIONS));

        if (productStocks.getQuantity() + productStocksRequestDto.getOrderQuantity() < 0) {
            throw new BaseException(BaseResponseStatus.INSUFFICIENT_STOCK);
        }

        productStocks.setQuantity(productStocks.getQuantity() + productStocksRequestDto.getOrderQuantity());

        if (productStocks.getQuantity() + productStocksRequestDto.getOrderQuantity() == 0) {
            subOption.setProductStatus(ProductStatus.SOLD_OUT);
        } else if (productStocks.getQuantity() + productStocksRequestDto.getOrderQuantity() > 0) {
            subOption.setProductStatus(ProductStatus.ON_SALE);
        }
    }

    @Override
    public ProductStocksResponseDto getProductStocks(Long subOptionId) {
        ProductStocks productStocks = productStocksRepository.findBySubOptionId(subOptionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        return ProductStocksResponseDto.builder()
                .subOptionId(productStocks.getSubOption().getId())
                .quantity(productStocks.getQuantity())
                .build();
    }

    @Override
    public List<ProductImagesResponseDto> getProductImageListByMainOptionId(Long mainOptionId) {
        MainOption mainOption = mainOptionRepository.findById(mainOptionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        return productImagesRepository.findByMainOptionId(mainOptionId)
                .stream().map(ProductImagesResponseDto::from)
                .toList();
    }

    @Override
    public List<SubOptionResponseDto> getSubOptionListByMainOptionId(Long mainOptionId) {
        MainOption mainOption = mainOptionRepository.findById(mainOptionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_OPTION));
        return subOptionRepository.findByMainOptionId(mainOptionId)
                .stream().map(SubOptionResponseDto::from)
                .toList();
    }
}
