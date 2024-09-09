package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.option.dto.ProductColorsRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductOptionsRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductSizesRequestDto;
import com.academy.sivillageclonebe.option.dto.ProductStatusRequestDto;

public interface OptionService {

    void createProductColors(ProductColorsRequestDto productColorsRequestDto);
    void createProductOptions(ProductOptionsRequestDto productOptionsRequestDto);
    void createProductSizes(ProductSizesRequestDto productSizesRequestDto);
    void createProductStatus(ProductStatusRequestDto productStatusRequestDto);

}
