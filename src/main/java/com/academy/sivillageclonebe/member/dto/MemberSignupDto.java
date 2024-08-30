package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.vo.MemberRequestVo;
import com.academy.sivillageclonebe.member.vo.MemberResponseVo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberSignupDto {

    private Long id;
    private Long roleId;
    private Long oauthId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .roleId(roleId)
                .oauthId(oauthId)
                .username(username)
                .password(password)
                .name(name)
                .phone(phone)
                .isDeleted(false)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public MemberResponseVo toResponseVo() {
        return MemberResponseVo.builder()
                .id(id)
                .roleId(roleId)
                .oauthId(oauthId)
                .username(username)
                .phone(phone)
                .isDeleted(isDeleted)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
