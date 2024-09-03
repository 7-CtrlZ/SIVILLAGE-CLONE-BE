package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.MemberAddressAddRequestDto;
import com.academy.sivillageclonebe.member.entity.MemberAddress;

public interface MemberAddressService {

    void saveMemberAddress(MemberAddressAddRequestDto memberAddressAddRequestDto);

}
