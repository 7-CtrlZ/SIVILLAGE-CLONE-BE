package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.MemberAddressDto;
import com.academy.sivillageclonebe.member.dto.MemberAddressRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import com.academy.sivillageclonebe.member.repository.MemberAddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MemberAddressServiceImpl implements MemberAddressService{

    private final MemberAddressRepository memberAddressRepository;

    @Override
    public void saveMemberAddress(MemberAddressRequestDto memberAddressRequestDto) {
        if (memberAddressRequestDto.isDefaultAddress()) {
            Optional<MemberAddress> existingDefaultAddress = memberAddressRepository.findByMemberAndDefaultAddress(memberAddressRequestDto.getMember(), true);
            existingDefaultAddress.ifPresent(address -> {
                address.editDefaultAddress(false);
                memberAddressRepository.save(address);
            });
        }
        memberAddressRepository.save(memberAddressRequestDto.toEntity());
    }

    @Override
    public List<MemberAddress> findAllByMember(Member member) {
        return memberAddressRepository.findAllByMember(member);
    }

    @Override
    public MemberAddress findByIdAndMember(Long id, Member member) {
        return memberAddressRepository.findByIdAndMember(id, member)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @Override
    public void updateMemberAddress(Long id, MemberAddressDto memberAddressDto) {
        MemberAddress existingAddress = memberAddressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        if (memberAddressDto.isDefaultAddress()) {
            Optional<MemberAddress> existingDefaultAddress = memberAddressRepository.findByMemberAndDefaultAddress(existingAddress.getMember(), true);
            existingDefaultAddress.ifPresent(address -> {
                address.editDefaultAddress(false);
                memberAddressRepository.save(address);
            });
        }

        existingAddress.editMemberAddress(memberAddressDto);
    }

    @Override
    public void deleteMemberAddress(Long id, Member member) {
        MemberAddress existingAddress = findByIdAndMember(id, member);
        memberAddressRepository.delete(existingAddress);
    }
}
