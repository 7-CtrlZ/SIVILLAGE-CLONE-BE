package com.academy.sivillageclonebe.member.dto;

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
    private Long memberId; ;
    private String address;
    private String zipCode;
    private String request;
    private String receiverName;
    private String receiverPhone;
    private boolean isDefault;

    public MemberAddress toEntity() {
        return MemberAddress.builder()
                .build();
    }
}
