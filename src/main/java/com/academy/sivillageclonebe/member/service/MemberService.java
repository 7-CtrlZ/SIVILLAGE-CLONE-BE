package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.MemberSignupDto;
import com.academy.sivillageclonebe.member.entity.Member;

public interface MemberService {

    void signUp(MemberSignupDto memberSignupDto);

    MemberSignupDto getMemberById(Long id);
    MemberSignupDto getMemberByUsername(String username);
}
