package com.academy.sivillageclonebe.like.service;

import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.like.dto.LikesRequestDto;
import com.academy.sivillageclonebe.like.entity.Likes;
import com.academy.sivillageclonebe.like.repository.LikesRepository;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.repository.MainOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {

    private final LikesRepository likesRepository;
    private final SecurityUtils securityUtils;
    private final MainOptionRepository mainOptionRepository;

    @Transactional
    @Override
    public void createLikes(LikesRequestDto likesRequestDto) {
        MainOption mainOption = mainOptionRepository.findById(likesRequestDto.getMainOptionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 메인 옵션이 없습니다."));
        Member member = securityUtils.getAuthenticatedMember();
        likesRepository.findByMemberIdAndMainOptionId(member.getId(), mainOption.getId())
                 .ifPresent(likes -> {throw new IllegalArgumentException("이미 찜한 항목입니다.");
                 });
        Likes likes = likesRequestDto.toEntity(member);
        likesRepository.save(likes);
    }

    @Override
    public boolean getLikes(Long memberId, Long mainOptionId) {
        return likesRepository.existsByMemberIdAndMainOptionId(memberId, mainOptionId);
    }

    @Override
    public void deleteLikes(Long memberId, Long mainOptionId) {
        Likes likes = likesRepository.findByMemberIdAndMainOptionId(memberId, mainOptionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메인 옵션이 없습니다."));

        likesRepository.delete(likes);

    }
}
