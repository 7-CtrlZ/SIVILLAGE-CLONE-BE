package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.option.vo.BrandRequestVo;
import com.academy.sivillageclonebe.option.vo.BrandResponseVo;
import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import com.academy.sivillageclonebe.vendor.dto.BrandResponseDto;
import com.academy.sivillageclonebe.vendor.service.BrandService;
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

    @PostMapping("/brand")
    public CommonResponseEntity<Void> createBrand(
            @RequestBody BrandRequestVo brandRequestVo) {
        log.info("BrandRequestVo : {}", brandRequestVo);
        BrandRequestDto brandRequestDto = BrandRequestDto.builder()
                .brandName(brandRequestVo.getBrandName())
                .build();
        brandService.createBrand(brandRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }
    @GetMapping("/{brandId}")
    public CommonResponseEntity<BrandResponseVo> getBrandNameById (@PathVariable Integer brandId) {
        BrandResponseDto brandResponseDto = brandService.getBrandNameById(brandId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "브랜드 조회 성공",
                brandResponseDto.toVo()
        );
    }
}
