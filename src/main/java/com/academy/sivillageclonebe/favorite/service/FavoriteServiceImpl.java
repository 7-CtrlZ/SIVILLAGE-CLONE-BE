package com.academy.sivillageclonebe.favorite.service;

import com.academy.sivillageclonebe.cart.dto.ProductsByCartUpdateDto;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.favorite.dto.FavoriteRequestDto;
import com.academy.sivillageclonebe.favorite.entity.Favorite;
import com.academy.sivillageclonebe.favorite.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Transactional
    @Override
    public void addFavorite(FavoriteRequestDto favoriteRequestDto) {
        favoriteRepository.save(favoriteRequestDto.toEntity());
    }

    @Override
    public boolean getFavorite(String memberUuid, Long mainOptionId) {
        return favoriteRepository.existsByMemberUuidAndMainOptionId(memberUuid, mainOptionId);
    }

    @Override
    public void deleteFavorite(Long mainOptionId) {
        favoriteRepository.deleteByMainOptionId(mainOptionId);

    }
}
