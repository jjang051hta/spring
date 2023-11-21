package com.jjang051.board.service;

import com.jjang051.board.dao.MemberDao;
import com.jjang051.board.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberDao memberDao;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public int insertMember(@ModelAttribute JoinDto joinDto) {
        JoinDto insertJoinDto = JoinDto.builder()
                .userId(joinDto.getUserId())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .email(joinDto.getEmail())
                .name(joinDto.getName())
                .build();
        int result = memberDao.insertMember(insertJoinDto);
        return result;
    }
}
