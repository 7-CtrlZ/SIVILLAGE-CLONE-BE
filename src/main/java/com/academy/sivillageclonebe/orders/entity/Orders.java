package com.academy.sivillageclonebe.orders.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, length = 20)
    private String ordererName;
    @Column(nullable = false, length = 20)
    private String ordererPhone;
    @Column(nullable = false, length = 20)
    private String receiverName;
    @Column(nullable = false, length = 20)
    private String receiverPhone;
    @Column(nullable = false)
    private Long totalPrice;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 20)
    private String zipCode;
    @Column(nullable = false)
    private String request;

    @Builder
    public Orders(
            OrderStatus orderStatus,
            String ordererName,
            String ordererPhone,
            String receiverName,
            String receiverPhone,
            Long totalPrice,
            String address,
            String zipCode,
            String request
    ) {
        this.orderStatus = orderStatus;
        this.ordererName = ordererName;
        this.ordererPhone = ordererPhone;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.totalPrice = totalPrice;
        this.address = address;
        this.zipCode = zipCode;
        this.request = request;
    }

    @PrePersist
    public void generateUUID() {
        this.uuid = UUID.randomUUID().toString();
    }
}
