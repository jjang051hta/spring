package com.jjang051.jpa.service;

import com.jjang051.jpa.dto.BoardDto;
import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.exception.DataNotFoundException;
import com.jjang051.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    // 얘가 db에 왔다 갔다 하는 애....
    private final BoardRepository boardRepository;

    public BoardDto insertBoard(Board02 board02){
        Board02 board = boardRepository.save(board02);
        return BoardDto.fromEntity(board);
    }


//    public Page<Board02> getAllPageBoard(int page) {
//        return  boardRepository.findAll(pageable);
//    }

    public List<Board02> getAllBoard() {
        List<Board02> boardList = boardRepository.findAll();
        return boardList;
    }

    public Page<Board02> getAllPageBoard(int page) {
        Pageable pageable = PageRequest.of(page,10,
                Sort.by(Sort.Direction.DESC,"createDate"));
        Page<Board02> boardList = boardRepository.findAll(pageable);
        return boardList;
    }


    // Optional
    public Board02 getBoard(int id) {
        Optional<Board02> board = boardRepository.findById(id);
        if(board.isPresent()) {
            return board.get();
        }
        throw new DataNotFoundException("찾는 거 없음");
        //return null;
    }


    public Page<Board02> getSearchBoard(String category,String keyword, int page) {
        Pageable pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC,"createDate"));
        if(category.equals("subject")) {
            Page<Board02> boardList = boardRepository.findBySubject(keyword, pageable);
            return boardList;
        } else if(category.equals("content")) {
            Page<Board02> boardList = boardRepository.findByContent(keyword, pageable);
            return boardList;
        }else if(category.equals("writer")) {
            Page<Board02> boardList = boardRepository.findByWriter(keyword, pageable);
            return boardList;
        }
        throw new RuntimeException("검색 결과가 없습니다.");
    }
}
