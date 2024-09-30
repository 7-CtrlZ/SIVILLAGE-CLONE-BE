package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.dto.MemberAddressRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberAddressRequestVo {
    private String address;
    private String zipCode;
    private String request;
    private String receiverName;
    private String receiverPhone;
    private boolean defaultAddress;

    @Builder
    public MemberAddressRequestDto toDto(Member member) {
        return MemberAddressRequestDto.builder()
                .member(member)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .defaultAddress(defaultAddress)
                .build();
    }

}
