package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.entity.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SignUpRequestDto {

    private Long id;
    private Integer roleId;
    private Integer oauthId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted = false;

    public Member toEntity(PasswordEncoder passwordEncoder, Role role, Oauth oauth) {
        return Member.builder()
                .id(id)
                .role(role)
                .oauth(oauth)
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phone(phone)
                .isDeleted(isDeleted)
                .build();
    }

}
