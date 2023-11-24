package com.jjang051.board.service;

import com.jjang051.board.code.ErrorCode;
import com.jjang051.board.dao.MemberDao;
import com.jjang051.board.dto.JoinDto;
import com.jjang051.board.dto.LoginDto;
import com.jjang051.board.exception.MemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        //여기다가 MemberException 을 터트려서 오류 처리 해보기...
        //오류 코드는 DUPLICATE_MEMBER로 해보기....
        int result = memberDao.insertMember(insertJoinDto);
        log.info("result==={}",result);
        if(result<=0) {
            throw new MemberException(ErrorCode.DUPLICATE_MEMBER);
        }
        return result;
    }


    @Transactional
    public  int deleteMember(@ModelAttribute LoginDto loginDto) {
        int result = 0;
        JoinDto dbLoginDto = memberDao.loginMember(loginDto.getUserId());
        // 정보를 다 얻어 올 수 있다.
        if(bCryptPasswordEncoder.matches(loginDto.getPassword(),dbLoginDto.getPassword())){
            log.info("비밀번호 같다.");
            String state = null;
            result = memberDao.deleteMember(loginDto);
            /*if(state==null) {
                throw new RuntimeException("에러남");
            }*/
            memberDao.insertDeleteMember(dbLoginDto);


        }
        return result;
    }

    @Transactional
    public int updateMember(@ModelAttribute JoinDto joinDto) {
        int result = 0;
        JoinDto dbLoginDto = memberDao.loginMember(joinDto.getUserId());
        // 정보를 다 얻어 올 수 있다.
        if(bCryptPasswordEncoder.matches(joinDto.getPassword(),dbLoginDto.getPassword())){
            result = memberDao.updateMember(joinDto);
        }
        return result;
    }


    /*@Transactional
    public int updatePassword(UpdatePasswordDto updatePasswordDto) {
        UpdatePasswordDto dbUpdatePasswordDto = UpdatePasswordDto.builder()
                .userId(updatePasswordDto.getUserId())
                .password(bCryptPasswordEncoder.encode(updatePasswordDto.getPassword()))
                .build();
        int result = memberDao.updatePassword(dbUpdatePasswordDto);
        return result;
    }*/
}
