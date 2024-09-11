package com.academy.sivillageclonebe.option.contorller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.service.OptionService;
import com.academy.sivillageclonebe.option.vo.*;
import com.academy.sivillageclonebe.product.vo.ProductRequestVo;
import com.academy.sivillageclonebe.vendor.service.ProductByCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/option")
public class OptionController {

    public final OptionService optionService;

    @PostMapping("/colors")
    public CommonResponseEntity<Void> createProductColors(
            @RequestBody ProductColorsRequestVo productColorsRequestVo) {
        log.info("productColorsRequestVo : {}", productColorsRequestVo);
        ProductColorsRequestDto productColorsRequestDto = ProductColorsRequestDto.builder()
                .colorName(productColorsRequestVo.getColorName())
                .build();
        optionService.createProductColors(productColorsRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/options")
    public CommonResponseEntity<Void> createProductOptions(
            @RequestBody ProductOptionsRequestVo productOptionsRequestVo) {
        log.info("productOptionsRequestVo : {}", productOptionsRequestVo);
        ProductOptionsRequestDto productOptionsRequestDto = ProductOptionsRequestDto.builder()
                .optionName(productOptionsRequestVo.getOptionName())
                .build();
        optionService.createProductOptions(productOptionsRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/status")
    public CommonResponseEntity<Void> createProductStatus(
            @RequestBody ProductStatusRequestVo productStatusRequestVo) {
        log.info("productStatusRequestVo : {}", productStatusRequestVo);
        ProductStatusRequestDto productStatusRequestDto = ProductStatusRequestDto.builder()
                .statusName(productStatusRequestVo.getStatusName())
                .build();
        optionService.createProductStatus(productStatusRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/stocks")
    public CommonResponseEntity<Void> createProductStocks(
            @RequestBody ProductStocksRequestVo productStocksRequestVo) {
        log.info("ProductStocksRequestVo : {}", productStocksRequestVo);
        ProductStocksRequestDto productStocksRequestDto = ProductStocksRequestDto.builder()
                .quantity(productStocksRequestVo.getQuantity())
                .productByOptionId(productStocksRequestVo.getProductByOptionId())
                .build();
        optionService.createProductStocks(productStocksRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }
}
