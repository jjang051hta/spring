package com.jjang051.board.dao;

import com.jjang051.board.dto.JoinDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insertMember(JoinDto joinDto);
    JoinDto loginMember(String username);
}
