package com.jjang051.board.dao;

import com.jjang051.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// dao가 db에 dto 입출력

@Mapper
public interface BoardDao {
    public List<BoardDto> getAllBoard();
}
