package com.jjang051.jpa.service;

import com.jjang051.jpa.dto.MemberDto;
import com.jjang051.jpa.entity.Member02;
import com.jjang051.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;



    public MemberDto join(MemberDto memberDto) {
        MyFunction func = (x,y)->{return x+y;};
                Member02 dbJoinMember = Member02.builder()
                .userId(memberDto.getUserId())
                .email(memberDto.getEmail())
                .nickName(memberDto.getNickName())
                .age(memberDto.getAge())
                .build();
        Member02 responseMember = memberRepository.save(dbJoinMember);
        MemberDto responseMemberDto = MemberDto.fromEntity(responseMember);
        return responseMemberDto;
    }

    public List<MemberDto> getAllMember() {
        // stream과 lamda를 쓰면 이걸 간단히 줄일수 있다....
        List<Member02> member02List = memberRepository.findAll();
        List<MemberDto> memberList = new ArrayList<>();
        for(int i=0;i<member02List.size();i++) {
            memberList.add(MemberDto.fromEntity(member02List.get(i)));
        }
        return memberList;
        /*return memberRepository.findAll()
                .stream()
                .map(MemberDto::fromEntity)
                .collect(Collectors.toList());*/
        // 반목문 돌려서 dto memberList에 담기...
        //return  memberList;
    }

    public MemberDto getMemberInfo(String id) {
        Optional<Member02> member = memberRepository.findById(id);
        if(member.isPresent()) {
            MemberDto memberInfo = MemberDto.fromEntity(member.get());
            return memberInfo;
        }
        return null;
        //throw new NotFoundMember("찾는 사람이 없습니다.");
    }
}
