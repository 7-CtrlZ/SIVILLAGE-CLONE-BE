package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.service.BrandService;
import com.academy.sivillageclonebe.vendor.vo.BrandRequestVo;
import com.academy.sivillageclonebe.vendor.vo.BrandResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vendor")
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "브랜드 등록 API", description = "브랜드 등록 API 입니다.", tags = {"Brand"})
    @PostMapping("/brand")
    public CommonResponseEntity<Void> createBrand(
            @RequestBody BrandRequestVo brandRequestVo) {
        brandService.createBrand(brandRequestVo.toDto());
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @Operation(summary = "브랜드 조회 API", description = "brandId를 사용한 브랜드 조회 API 입니다.", tags = {"Brand"})
    @GetMapping("brand/{brandId}")
    public CommonResponseEntity<BrandResponseVo> getBrandById (@PathVariable Integer brandId) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                brandService.getBrandById(brandId).toVo()
        );
    }
}
