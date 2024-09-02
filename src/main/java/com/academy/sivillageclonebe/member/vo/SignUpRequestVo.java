package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.dto.SignUpRequestDto;
import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class SignUpRequestVo {

    private Role role;
    private String email;
    private String password;
    private String name;
    private String phone;

    @Builder
    public SignUpRequestDto toDto(){
        return SignUpRequestDto.builder()
                .role(role)
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
    }

}