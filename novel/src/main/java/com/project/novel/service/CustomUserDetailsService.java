package com.project.novel.service;

import com.project.novel.dto.CustomUserDetails;
import com.project.novel.entity.Member;
import com.project.novel.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        System.out.println("userId===="+userId);
//        Optional<Member> loggedMember = memberRepository.findByUserId(userId);
//        System.out.println("여기로 오냐/////");
//        if(loggedMember.isPresent()) {
//            System.out.println("확인 됨.");
//            return new CustomUserDetails(loggedMember.get());
//        }
//        System.out.println("비번 틀림...");
//        throw new UsernameNotFoundException("아이디와 비밀번호를 확인해주세요.");
        Optional<Member> loggedMember = memberRepository.findByUserId(userId); // 6개의 속성을 가진애를
        if(loggedMember.isPresent()) {
            System.out.println("확인 됨.");
            return new CustomUserDetails(loggedMember.get());

        }
        System.out.println("아이디 패스 틀림...");
        throw new UsernameNotFoundException("아이디 패스워드 확인해 주세요.");
    }
}
