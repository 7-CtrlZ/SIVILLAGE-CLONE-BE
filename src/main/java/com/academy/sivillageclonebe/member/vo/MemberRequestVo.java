package com.academy.sivillageclonebe.member.vo;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class MemberRequestVo {

    private Long roleId;
    private Long oauthId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
