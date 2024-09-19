package com.academy.sivillageclonebe.option.service;

import com.academy.sivillageclonebe.admin.dto.SubCategoryResponseDto;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import com.academy.sivillageclonebe.option.dto.*;
import com.academy.sivillageclonebe.option.entity.*;
import com.academy.sivillageclonebe.option.repository.*;
import com.academy.sivillageclonebe.product.entity.Product;
import com.academy.sivillageclonebe.product.repository.ProductRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.academy.sivillageclonebe.option.entity.QProductStocks.productStocks;

@Slf4j
@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService {

    private final ProductStocksRepository productStocksRepository;
    private final ProductImagesRepository productImagesRepository;
    private final MainOptionRepository mainOptionRepository;
    private final SubOptionRepository subOptionRepository;
    private final ProductRepository productRepository;

    @Override
    public void createMainOptions(MainOptionRequestDto mainOptionRequestDto) {
        Product product = productRepository.findById(mainOptionRequestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
                );
        mainOptionRepository.save(mainOptionRequestDto.toEntity(product));
    }

    @Override
    public void createSubOptions(SubOptionRequestDto subOptionRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(subOptionRequestDto.getMainOptionId())
                .orElseThrow(() -> new RuntimeException("해당 메인 옵션이 없습니다."));

        subOptionRepository.save(subOptionRequestDto.toEntity(mainOption));
    }

    @Override
    public void createProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        SubOption subOption = subOptionRepository.findById(
                        productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다.")
                );
        productStocksRepository.save(productStocksRequestDto.toEntity());
    }

    @Override
    public void createProductImages(ProductImagesRequestDto productImagesRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(productImagesRequestDto.getMainOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다.")
                );
        productImagesRepository.save(productImagesRequestDto.toEntity(mainOption));
    }

//    @Override
//    public void updateProductStocks(ProductStocksRequestDto productStocksRequestDto) {
//        SubOption subOption = subOptionRepository.findById(productStocksRequestDto.getSubOptionId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다."));
//
//
//        productStocksRepository.save(productStocksRequestDto.toEntity());
//
//        if (productStocksRequestDto.getQuantity() == 0) {
//            subOption.getProductStatus(ProductStatus.SOLD_OUT);
//        }
//        else if (productStocksRequestDto.getQuantity() > 0) {
//            subOption.getProductStatus(ProductStatus.ON_SALE);
//        }
//        subOptionRepository.save(subOption);
//    }

    @Override
    public void updateProductStocks(ProductStocksRequestDto productStocksRequestDto) {
        SubOption subOption = subOptionRepository.findById(productStocksRequestDto.getSubOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다."));

//        ProductStocks productStocks = productStocksRepository.findById(productStocksRequestDto.getSubOptionId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 재고 정보가 존재하지 않습니다."));
//
//        int currentStock = productStocks.getQuantity();
//        int updatedStock;
//
//        if (productStocksRequestDto.getOrderQuantity() < 0) {
//            updatedStock = currentStock - productStocksRequestDto.getOrderQuantity();
//        } else if (productStocksRequestDto.getOrderQuantity() > 0) {
//            updatedStock = currentStock + productStocksRequestDto.getOrderQuantity();
//        }

        productStocksRepository.save(productStocksRequestDto.toEntity());

        if (productStocksRequestDto.getQuantity() == 0) {
            subOption.getProductStatus(ProductStatus.SOLD_OUT);
        }
        else if (productStocksRequestDto.getQuantity() > 0) {
            subOption.getProductStatus(ProductStatus.ON_SALE);
        }
        subOptionRepository.save(subOption);
    }

    @Override
    public ProductStocksResponseDto getProductStocks(Long subOptionId) {
        ProductStocks productStocks = productStocksRepository.findById(subOptionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 존재하지 않습니다.")
                );
        return ProductStocksResponseDto.builder()
                .subOptionId(productStocks.getSubOptionId())
                .quantity(productStocks.getQuantity())
                .build();
    }

    @Override
    public List<MainOptionResponseDto> getMainOptionListByProductId(Long productId) {
        List<MainOption> mainOptionList = mainOptionRepository.findByProductId(productId);
        return mainOptionList.stream().map(mainOption -> MainOptionResponseDto.builder()
                .mainOptionName(mainOption.getMainOptionName())
                .productId(mainOption.getProduct().getId())
                .mainOptionId(mainOption.getId())
                .build())
        .toList();
    }

    @Override
    public List<ProductImagesResponseDto> getProductImageListByMainOptionId(Long mainOptionId) {
        List<ProductImages> productImagesList = productImagesRepository.findByMainOptionId(mainOptionId);
        return productImagesList.stream().map(productImages -> ProductImagesResponseDto.builder()
                        .isMainImage(productImages.getIsMainImage())
                        .imageDescription(productImages.getImageDescription())
                        .imageUrl(productImages.getImageUrl())
                        .mainOptionId(productImages.getMainOption().getId())
                        .build())
                .toList();
    }

    @Override
    public List<SubOptionResponseDto> getSubOptionListByMainOptionId(Long mainOptionId) {
        List<SubOption> subOptionList = subOptionRepository.findByMainOptionId(mainOptionId);
        return subOptionList.stream().map(subOption -> SubOptionResponseDto.builder()
                        .mainOptionId(subOption.getMainOption().getId())
                        .subOptionId(subOption.getId())
                        .optionName(subOption.getOptionName())
                        .productStatus(subOption.getProductStatus())
                        .build())
                .toList();
    }
}
