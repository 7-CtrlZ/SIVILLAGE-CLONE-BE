package com.academy.sivillageclonebe.option.service;


import com.academy.sivillageclonebe.option.dto.*;

import java.util.List;

public interface OptionService {

    void createSubOptions(SubOptionRequestDto subOptionRequestDto);
    void createMainOptions(MainOptionRequestDto mainOptionRequestDto);
    void createProductOptions(ProductOptionsRequestDto productOptionsRequestDto);
    void createProductStatus(ProductStatusRequestDto productStatusRequestDto);
    void createProductStocks(ProductStocksRequestDto productStocksRequestDto);
    void createProductImages(ProductImagesRequestDto productImagesRequestDto);

    List<MainOptionResponseDto> getMainOptionListByProductId(Long productId);
  List<ProductImagesResponseDto> getProductImageListByMainOptionId(Long mainOptionId);

}
