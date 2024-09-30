package com.academy.sivillageclonebe.member.repository;

import com.academy.sivillageclonebe.member.entity.Oauth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRepository extends JpaRepository<Oauth, Integer> {
}
