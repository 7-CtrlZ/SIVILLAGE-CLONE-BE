package com.academy.sivillageclonebe.member.vo;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseVo {

    private Long id;
    private Long roleId;
    private Long oauthId;
    private String username;
    private String name;
    private String phone;
    private boolean isDeleted;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
