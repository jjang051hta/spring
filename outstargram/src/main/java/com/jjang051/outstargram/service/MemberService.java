package com.jjang051.outstargram.service;

import com.jjang051.outstargram.constant.Role;
import com.jjang051.outstargram.dto.JoinDto;
import com.jjang051.outstargram.dto.UpdateMemberDto;
import com.jjang051.outstargram.entity.Member;
import com.jjang051.outstargram.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
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

    @Transactional
    public void updateMember(int id,UpdateMemberDto updateMemberDto) {
        log.info("id==={}",id);
        log.info("updateMemberDto==={}",updateMemberDto.toString());

        Optional<Member> findMember =  memberRepository.findById(id);
        if(findMember.isPresent()) {
            Member member = findMember.get();
            member.setMbti(updateMemberDto.getMbti());
            member.setEmail(updateMemberDto.getEmail());
            member.setPhone(updateMemberDto.getPhone());
            member.setDescription(updateMemberDto.getDescription());
            member.setName(updateMemberDto.getName());
            //memberRepository.save(member);
        } else {
            throw new UsernameNotFoundException("서버 오류입니다.");
        }
    }
}
