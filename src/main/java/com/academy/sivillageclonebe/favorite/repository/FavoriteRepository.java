package com.academy.sivillageclonebe.favorite.repository;

import com.academy.sivillageclonebe.favorite.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    void deleteByMainOptionId(Long mainOptionId);
    boolean existsByMemberUuidAndMainOptionId(String memberUuid, Long mainOptionId);
}
