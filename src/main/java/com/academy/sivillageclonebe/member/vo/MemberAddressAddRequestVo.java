package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.dto.MemberAddressAddRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberAddressAddRequestVo {
    private String address;
    private String zipCode;
    private String request;
    private String receiverName;
    private String receiverPhone;
    private boolean isDefault;

    @Builder
    public MemberAddressAddRequestDto toDto(Member member) {
        return MemberAddressAddRequestDto.builder()
                .member(member)
                .address(address)
                .zipCode(zipCode)
                .request(request)
                .receiverName(receiverName)
                .receiverPhone(receiverPhone)
                .isDefault(isDefault)
                .build();
    }

}
