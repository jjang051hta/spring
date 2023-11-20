package com.jjang051.isotope.dao;

import com.jjang051.isotope.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insertMember(MemberDto memberDto);
    MemberDto loginMember(String username);
}
