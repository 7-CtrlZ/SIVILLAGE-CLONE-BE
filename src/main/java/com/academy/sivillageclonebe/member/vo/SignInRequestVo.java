package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.dto.SignInRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SignInRequestVo {

    private String email;
    private String password;

    @Builder
    public SignInRequestDto toDto() {
        return SignInRequestDto.builder()
                .email(email)
                .password(password)
                .build();
    }

}