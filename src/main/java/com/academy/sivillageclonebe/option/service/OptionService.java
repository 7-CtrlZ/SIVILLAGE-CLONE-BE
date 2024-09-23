package com.academy.sivillageclonebe.option.service;


import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.entity.ProductStatus;
import com.academy.sivillageclonebe.option.entity.ProductStocks;

import java.util.List;

public interface OptionService {

    void createSubOptions(SubOptionRequestDto subOptionRequestDto);
    void createMainOptions(MainOptionRequestDto mainOptionRequestDto);
    void createProductStocks(ProductStocksRequestDto productStocksRequestDto);
    void createProductImages(ProductImagesRequestDto productImagesRequestDto);
    void updateProductStocks(ProductStocksRequestDto productStocksRequestDto);

    ProductStocksResponseDto getProductStocks(Long subOptionId);
    List<MainOptionResponseDto> getMainOptionListByProductCode(String productCode);
    List<ProductImagesResponseDto> getProductImageListByMainOptionId(Long mainOptionId);
    List<SubOptionResponseDto> getSubOptionListByMainOptionId(Long subOptionId);

}
