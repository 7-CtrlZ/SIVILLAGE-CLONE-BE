package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.entity.Role;
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

}