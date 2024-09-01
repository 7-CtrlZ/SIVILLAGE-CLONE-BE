package com.academy.sivillageclonebe.member.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseVo {

    private String accessToken;
//    private String refreshToken;
    private String username;

}