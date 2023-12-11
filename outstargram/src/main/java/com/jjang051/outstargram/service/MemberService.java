package com.jjang051.outstargram.service;

import com.jjang051.outstargram.constant.Role;
import com.jjang051.outstargram.dto.JoinDto;
import com.jjang051.outstargram.entity.Member;
import com.jjang051.outstargram.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Member join(JoinDto joinDto) {
        Member dbJoinMEmber = Member.builder()
                .userId(joinDto.getUserId())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .role(Role.ROLE_USER)
                .email(joinDto.getEmail())
                .name(joinDto.getName())
                .build();
        return memberRepository.save(dbJoinMEmber);
    }
}
