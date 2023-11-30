package com.jjang051.jpa.service;

import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    // 얘가 db에 왔다 갔다 하는 애....
    private final BoardRepository boardRepository;

    public Board02 insertBoard(Board02 board02){
        Board02 board = boardRepository.save(board02);
        return board;
    }

    public List<Board02> getAllBoard() {
        List<Board02> boardList = boardRepository.findAll();
        return boardList;
    }
}
