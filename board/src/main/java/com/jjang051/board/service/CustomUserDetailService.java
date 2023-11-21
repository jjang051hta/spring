package com.jjang051.board.service;

import com.jjang051.board.dao.MemberDao;
import com.jjang051.board.dto.CustomUserDetails;
import com.jjang051.board.dto.JoinDto;
import com.jjang051.board.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberDao memberDao;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        //db에 있는지 없는지 따진다음 비밀번호는 시큐리티가 알아서 해준다.
         JoinDto loggedMember = memberDao.loginMember(userId);
         if(loggedMember==null) {
             // dto  userna
             throw new UsernameNotFoundException("fdsfd");

             //return null;
         }
        return new CustomUserDetails(loggedMember);
    }
}
