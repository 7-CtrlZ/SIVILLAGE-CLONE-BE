package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.*;

public interface OptionService {

    void createProductColors(ProductColorsRequestDto productColorsRequestDto);
    void createProductOptions(ProductOptionsRequestDto productOptionsRequestDto);
    void createProductStatus(ProductStatusRequestDto productStatusRequestDto);
    void createProductStocks(ProductStocksRequestDto productStocksRequestDto);


}
