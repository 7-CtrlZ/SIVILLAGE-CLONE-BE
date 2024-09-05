package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.MemberAddress;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberAddressDto {
    private String address;
    private String zipCode;
    private String request;
    private String receiverName;
    private String receiverPhone;
    private boolean isDefault;

    public static MemberAddressDto toEntity(MemberAddress address) {
        return MemberAddressDto.builder()
                .address(address.getAddress())
                .zipCode(address.getZipCode())
                .request(address.getRequest())
                .receiverName(address.getReceiverName())
                .receiverPhone(address.getReceiverPhone())
                .isDefault(address.isDefault())
                .build();
    }
}
