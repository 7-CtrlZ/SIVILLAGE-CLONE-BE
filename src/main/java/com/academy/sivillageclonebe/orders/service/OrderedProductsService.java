package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.orders.dto.OrderedProductsRequestDto;

import java.util.List;

public interface OrderedProductsService  {
    List<OrderedProductsRequestDto> getOrderedProducts(Long ordersId);
}
