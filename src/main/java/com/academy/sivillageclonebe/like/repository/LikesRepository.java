package com.academy.sivillageclonebe.like.repository;

import com.academy.sivillageclonebe.like.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    List<Likes> findByMemberId(Long memberId);

}
