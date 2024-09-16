package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.repository.MemberRepository;
import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersUpdateDto;
import com.academy.sivillageclonebe.orders.entity.Orders;
import com.academy.sivillageclonebe.orders.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final SecurityUtils securityUtils;

    @Override
    public void createOrder(OrdersRequestDto ordersRequestDto) {
        Member member = securityUtils.getAuthenticatedMember();
        ordersRepository.save(ordersRequestDto.toEntity(member));
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
    public void deleteOrder(String uuid) {
        ordersRepository.deleteByUuid(uuid);
    }
}
