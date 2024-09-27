package com.academy.sivillageclonebe.option.contorller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.option.dto.ProductImagesResponseDto;
import com.academy.sivillageclonebe.option.dto.SubOptionResponseDto;
import com.academy.sivillageclonebe.option.service.OptionService;
import com.academy.sivillageclonebe.option.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/option")
public class OptionController {

    public final OptionService optionService;
    
    @Operation(summary = "메인 옵션 등록 API", description = "메인 옵션 등록 API 입니다.", tags = {"Product"})
    @PostMapping("/mainOptions")
    public BaseResponse<Void> createMainOptions(
            @RequestBody MainOptionRequestVo mainOptionRequestVo) {
        optionService.createMainOptions(mainOptionRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "서브 옵션 등록 API", description = "서브 옵션 등록 API 입니다.", tags = {"Product"})
    @PostMapping("/subOptions")
    public BaseResponse<Void> createSubOptions(
            @RequestBody SubOptionRequestVo subOptionRequestVo) {
        optionService.createSubOptions(subOptionRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "재고 등록 API", description = "재고 등록 API 입니다.", tags = {"Product"})
    @PostMapping("/stocks/{subOptionId}")
    public BaseResponse<Void> createProductStocks(
            @PathVariable Long subOptionId,
            @RequestBody ProductStocksRequestVo productStocksRequestVo) {
        optionService.createProductStocks(productStocksRequestVo.toDto(subOptionId));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "상품 이미지 등록 API", description = "상품 이미지 등록 API 입니다.", tags = {"Product"})
    @PostMapping("/images")
    public BaseResponse<Void> createProductImages(
            @RequestBody ProductImagesRequestVo productImagesRequestVo) {
        optionService.createProductImages(productImagesRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    
    @Operation(summary = "상품 이미지 조회 API", description = "상품 이미지 조회 API 입니다.", tags = {"Product"})
    @GetMapping("/mainOptionId/{mainOptionId}/images")
    public BaseResponse<List<ProductImagesResponseVo>> getImage(@PathVariable Long mainOptionId) {
        return new BaseResponse<>(
                optionService.getProductImageListByMainOptionId(mainOptionId)
                        .stream().map(ProductImagesResponseDto::toVo)
                        .toList());
    }

    @Operation(summary = "서브 옵션 조회 API", description = "서브 옵션 조회 API 입니다.", tags = {"Product"})
    @GetMapping("/mainOptionId/{mainOptionId}/subOptions")
    public BaseResponse<List<SubOptionResponseVo>> getSubOption(@PathVariable Long mainOptionId) {
        return new BaseResponse<>(
                optionService.getSubOptionListByMainOptionId(mainOptionId)
                        .stream().map(SubOptionResponseDto::toVo)
                        .toList());
    }

    @Operation(summary = "재고 조회 API", description = "재고 조회 API 입니다.", tags = {"Product"})
    @GetMapping("/subOptionId/{subOptionId}/productStocks")
    public BaseResponse<ProductStocksResponseVo> getProductStocks(@PathVariable Long subOptionId) {
        return new BaseResponse<>(
                optionService.getProductStocks(subOptionId).toVo()
        );
    }

    @Operation(summary = "재고 업데이트 API", description = "재고 업데이트 API 입니다.", tags = {"Product"})
    @PutMapping("productStocks/{subOptionId}")
    public BaseResponse<Void> updateProductStocks(
            @PathVariable Long subOptionId,
            @RequestBody ProductStocksRequestVo productStocksRequestVo) {
        optionService.updateProductStocks(productStocksRequestVo.toDto(subOptionId));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
