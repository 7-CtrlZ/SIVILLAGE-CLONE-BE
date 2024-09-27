package com.academy.sivillageclonebe.cart.service;

import com.academy.sivillageclonebe.cart.dto.CartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartDto;
import com.academy.sivillageclonebe.cart.dto.ProductsByCartUpdateDto;
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
    private final ProductService productService;    //repository를 불러 오는 것이 좋다

    @Override
    public void addProductToCart(CartDto cartDto, ProductsByCartDto productsByCartDto) {

        productsByCartRepository.save(productsByCartDto.toEntity(cartRepository.findByMemberIdAndBrandId(
                        cartDto.getMemberId(), productService.getBrandIdByProductCode(productsByCartDto.getProductCode()))
                .orElseGet(() -> cartRepository.save(cartDto.toEntity()))));

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

        productsByCart.editCheck(productsByCart.isChecked());

    }

    @Override
    public void updateOption(Long productsByCartId, ProductsByCartUpdateDto productsByCartUpdateDto) {

        ProductsByCart productsByCart = productsByCartRepository.findById(productsByCartId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        productsByCart.editCart(productsByCartUpdateDto);

    }

}
