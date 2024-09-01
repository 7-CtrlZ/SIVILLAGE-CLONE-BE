package com.academy.sivillageclonebe.member.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class SignUpRequestVo {

    private Long roleId;
    private Long oauthId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted;

}