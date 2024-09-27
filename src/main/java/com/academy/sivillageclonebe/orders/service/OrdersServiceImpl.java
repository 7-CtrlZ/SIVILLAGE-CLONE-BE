package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersStatusUpdateDto;
import com.academy.sivillageclonebe.orders.dto.OrdersUpdateDto;
import com.academy.sivillageclonebe.orders.entity.OrderedProducts;
import com.academy.sivillageclonebe.orders.entity.Orders;
import com.academy.sivillageclonebe.orders.repository.OrderedProductsRepository;
import com.academy.sivillageclonebe.orders.repository.OrdersRepository;
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
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrderedProductsRepository orderedProductsRepository;
    private final SecurityUtils securityUtils;
    private final ProductService productService;

    @Override
    public void createOrder(OrdersRequestDto ordersRequestDto) {
        Member member = securityUtils.getAuthenticatedMember();
        Orders orders = ordersRequestDto.toEntity(member);
        ordersRepository.save(orders);

        List<OrderedProducts> orderedProductsList = ordersRequestDto.getOrderedProducts().stream()
                .map(productDto -> OrderedProducts.builder()
                        .orders(orders)
                        .productId(productDto.getProductId())
                        .orderedMainOption(productDto.getOrderedMainOption())
                        .orderedSubOption(productDto.getOrderedSubOption())
                        .price(productService.findByProductId(productDto.getProductId()).getPrice())
                        .quantity(productDto.getQuantity())
                        .build())
                .toList();
        Long totalPrice = orderedProductsList.stream()
                .mapToLong(product -> product.getPrice() * product.getQuantity())
                .sum();
        orders.editTotalPrice(totalPrice);

        orderedProductsRepository.saveAll(orderedProductsList);
    }

    @Override
    public List<Orders> getAllByMemberUuid(String memberUuid) {
        return ordersRepository.findAllByMemberUuid(memberUuid);
    }

    @Override
    public Orders getOrderByUuid(String uuid) {
        return ordersRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void updateOrder(String uuid, OrdersUpdateDto ordersUpdateDto) {
        Orders orders = ordersRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Order not found"));
        orders.editOrders(ordersUpdateDto);
    }

    @Override
    public void updateOrderStatus(String uuid, OrdersStatusUpdateDto ordersStatusUpdateDto) {
        Orders orders = ordersRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Order not found"));
        orders.editOrdersStatus(ordersStatusUpdateDto);
    }

    @Override
    public void deleteOrder(String uuid) {
        ordersRepository.deleteByUuid(uuid);
    }
}
