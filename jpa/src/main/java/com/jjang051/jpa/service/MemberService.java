package com.jjang051.jpa.service;

import com.jjang051.jpa.entity.Member02;
import com.jjang051.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member02 join(Member02 member) {
        Member02 responseMember = memberRepository.save(member);
        return responseMember;
    }

    public List<Member02> getAllMember() {
        List<Member02> memberList = memberRepository.findAll();
        return  memberList;
    }
}
