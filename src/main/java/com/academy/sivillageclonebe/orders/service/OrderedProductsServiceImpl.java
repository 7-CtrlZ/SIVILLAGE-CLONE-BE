package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.orders.entity.OrderedProducts;
import com.academy.sivillageclonebe.orders.repository.OrderedProductsRepository;
import com.academy.sivillageclonebe.orders.vo.OrderedProductsResponseVo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class OrderedProductsServiceImpl implements OrderedProductsService {

    private final OrderedProductsRepository orderedProductsRepository;

    @Override
    public List<OrderedProductsResponseVo> getOrderedProducts(Long ordersId) {
        List<OrderedProducts> orderedProductsList = orderedProductsRepository.findAllByOrdersId(ordersId);
        return orderedProductsList.stream()
                .map(OrderedProductsResponseVo::fromEntity)
                .collect(Collectors.toList());
    }
}
