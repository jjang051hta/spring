package com.jjang051.board.service;

import com.jjang051.board.dao.MemberDao;
import com.jjang051.board.dto.JoinDto;
import com.jjang051.board.dto.LoginDto;
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

    public  int deleteMember(@ModelAttribute LoginDto loginDto) {
        int result = 0;
        JoinDto dbLoginDto = memberDao.loginMember(loginDto.getUserId());
        // 정보를 다 얻어 올 수 있다.
        if(bCryptPasswordEncoder.matches(loginDto.getPassword(),dbLoginDto.getPassword())){
            log.info("비밀번호 같다.");
            result = memberDao.deleteMember(loginDto);
        }
        return result;
    }
}