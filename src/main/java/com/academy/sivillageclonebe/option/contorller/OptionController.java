package com.academy.sivillageclonebe.option.contorller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.service.OptionService;
import com.academy.sivillageclonebe.option.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/option")
public class OptionController {

    public final OptionService optionService;

    @PostMapping("/mainOptions")
    public CommonResponseEntity<Void> createMainOptions(
            @RequestBody MainOptionRequestVo mainOptionRequestVo) {
        log.info("mainOptionRequestVo: {}", mainOptionRequestVo);
        MainOptionRequestDto mainOptionRequestDto = MainOptionRequestDto.builder()
                .productId(mainOptionRequestVo.getProductId())
                .mainOptionName(mainOptionRequestVo.getMainOptionName())
                .build();
        optionService.createMainOptions(mainOptionRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/subOptions")
    public CommonResponseEntity<Void> createSubOptions(
            @RequestBody SubOptionRequestVo subOptionRequestVo) {
        log.info("subOptionRequestVo: {}", subOptionRequestVo);
        SubOptionRequestDto subOptionRequestDto = SubOptionRequestDto.builder()
                .mainOptionId(subOptionRequestVo.getMainOptionId())
                .productOptionId(subOptionRequestVo.getProductOptionId())
                .productStatusId(subOptionRequestVo.getProductStatusId())
                .isActive(subOptionRequestVo.getIsActive())
                .isDeleted(subOptionRequestVo.getIsDeleted())
                .build();
        optionService.createSubOptions(subOptionRequestDto);
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
                .subOptionId(productStocksRequestVo.getSubOptionId())
                .build();
        optionService.createProductStocks(productStocksRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/images")
    public CommonResponseEntity<Void> createProductImages(
            @RequestBody ProductImagesRequestVo productImagesRequestVo) {
        log.info("ProductImagesRequestVo : {}", productImagesRequestVo);
        ProductImagesRequestDto productImagesRequestDto = ProductImagesRequestDto.builder()
                .mainOptionId(productImagesRequestVo.getMainOptionId())
                .imageUrl(productImagesRequestVo.getImageUrl())
                .imageDescription(productImagesRequestVo.getImageDescription())
                .isMainImage(productImagesRequestVo.getIsMainImage())
                .build();
        optionService.createProductImages(productImagesRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @GetMapping("/product/{productId}/mainOption")
    public CommonResponseEntity<List<MainOptionResponseVo>> getMainOption(@PathVariable Long productId) {
        List<MainOptionResponseDto> mainOptionResponseDtoList = optionService.getMainOptionListByProductId(productId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "메인 옵션 조회 성공",
                mainOptionResponseDtoList.stream().map(MainOptionResponseDto::toVo).toList());
    }

    @GetMapping("/mainOption/{mainOptionId}/images")
    public CommonResponseEntity<List<ProductImagesResponseVo>> getImage(@PathVariable Long mainOptionId) {
        List<ProductImagesResponseDto> productImagesResponseDtoList = optionService.getProductImageListByMainOptionId(mainOptionId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "상품 사진 조회 성공",
                productImagesResponseDtoList.stream().map(ProductImagesResponseDto::toVo).toList());
    }
}
