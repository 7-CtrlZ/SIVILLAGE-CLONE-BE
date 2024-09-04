package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.vo.SignInResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {

    private String accessToken;
    private String refreshToken;
    private String name;

    public SignInResponseVo toVo() {
        return SignInResponseVo.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .name(name)
                .build();
    }

}