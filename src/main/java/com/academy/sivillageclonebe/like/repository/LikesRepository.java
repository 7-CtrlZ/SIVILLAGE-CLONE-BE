package com.academy.sivillageclonebe.like.repository;

import com.academy.sivillageclonebe.like.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByMemberIdAndMainOptionId(Long memberId, Long mainOptionId);
    boolean existsByMemberIdAndMainOptionId(Long memberId, Long mainOptionId);

}
