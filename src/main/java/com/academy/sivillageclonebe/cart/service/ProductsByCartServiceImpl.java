package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.cart.entity.ProductsByCart;
import com.academy.sivillageclonebe.cart.repository.CartRepository;
import com.academy.sivillageclonebe.cart.repository.ProductsByCartRepository;
import com.academy.sivillageclonebe.product.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class ProductsByCartServiceImpl implements ProductsByCartService{

    private final ProductsByCartRepository productsByCartRepository;
    private final CartRepository cartRepository;
    private final ProductService productService;

    @Override
    public void addProductToCart(CartDto cartDto, ProductsByCartDto productsByCartDto) {
        // productCode로 브랜드 정보를 조회
        Integer brandId = productService.getBrandIdByProductCode(productsByCartDto.getProductCode());

        // memberId와 brandId로 Cart 조회, 없으면 새로 생성
        Cart cart = cartRepository.findByMemberIdAndBrandId(cartDto.getMemberId(), brandId)
                .orElseGet(() -> cartRepository.save(cartDto.toEntity()));

        ProductsByCart productsByCart = productsByCartDto.toEntity(cart);

        productsByCartRepository.save(productsByCart);

    }

    @Override
    public ProductsByCart saveProduct(ProductsByCart productsByCart) {
        return productsByCartRepository.save(productsByCart);
    }

    @Override
    public List<ProductsByCart> findByCart(Cart cart) {
        return productsByCartRepository.findByCart(cart);
    }

    @Override
    public void removeProductFromCart(Long productsByCartId) {
        ProductsByCart productsByCart = productsByCartRepository.findById(productsByCartId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Cart cart = productsByCart.getCart();
        productsByCartRepository.delete(productsByCart);

        if (productsByCartRepository.countByCartId(cart.getId()) == 0) {
            cartRepository.delete(cart);
        }
    }

    @Override
    public ProductsByCart save(ProductsByCart productsByCart) {
        return productsByCartRepository.save(productsByCart);
    }

    @Override
    public void updateCheck(Long productsByCartId) {

        ProductsByCart productsByCart = productsByCartRepository.findById(productsByCartId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        log.info("ProductsByCartId {}: {}", productsByCartId, productsByCart.getProductCode());

        productsByCart.editCheck(!productsByCart.isChecked());

    }

}
