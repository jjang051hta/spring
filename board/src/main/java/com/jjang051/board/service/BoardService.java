package com.jjang051.board.service;

import com.jjang051.board.dao.BoardDao;
import com.jjang051.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    // spring container 에 등록된 bean을 주입받을때 쓴다.
    private final BoardDao boardDao;

//    public BoardService(BoardDao boardDao) {
//        this.boardDao = boardDao;
//    }

    public List<BoardDto> getAllBoard() {
        List<BoardDto> boardList = boardDao.getAllBoard();
        return boardList;
    }
    public int insertBoard(BoardDto boardDto) {
        int result = boardDao.insertBoard(boardDto);
        return result;
    }

    public int deleteBoard(int id) {
        int result = boardDao.deleteBoard(id);
        return result;
    }

    public BoardDto getOneBoard(int id) {
        BoardDto result = boardDao.getOneBoard(id);
        return result;
    }


//    public BoardDto getOneBoard(String name) {
//        BoardDto boardDto = boardDao.getOneBoard(name);
//        return boardDto;
//    }

}
