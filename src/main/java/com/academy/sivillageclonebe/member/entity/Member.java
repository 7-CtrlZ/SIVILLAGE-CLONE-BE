package com.academy.sivillageclonebe.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private Long role_id;

    @Column(nullable = false, length = 20)
    private Long oauth_id;

    @Comment("이메일")
    @Column(nullable = false, length = 20)
    private String username;

    @Column(length = 20)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private boolean is_deleted;

    @Column(nullable = false)
    private LocalDate created_at;
    @Column(nullable = false)
    private LocalDate updated_at;
}
