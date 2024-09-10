package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberAddressRequestDto {

    private Long id;
    private Member member;
    private String address;
    private String zipCode;
    private String request;
    private String receiverName;
    private String receiverPhone;
    private boolean isDefault;

    public MemberAddress toEntity() {
        return MemberAddress.builder()
                .id(id)
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
