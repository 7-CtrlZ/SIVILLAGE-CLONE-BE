package com.academy.sivillageclonebe.member.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SignInRequestVo {

    private String email;
    private String password;

}