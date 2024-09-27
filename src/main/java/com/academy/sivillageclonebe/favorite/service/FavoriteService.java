package com.academy.sivillageclonebe.favorite.service;


import com.academy.sivillageclonebe.favorite.dto.FavoriteRequestDto;

public interface FavoriteService {

    void addFavorite(FavoriteRequestDto likesRequestDto);
    boolean getFavorite(String memberUuid, Long mainOptionId);
    void deleteFavorite(Long mainOptionId);

}
