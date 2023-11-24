package com.jjang051.board.exception;

import com.jjang051.board.code.ErrorCode;
import com.jjang051.board.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    // 여기에 에러 다 모아서 쓰기....
    @ExceptionHandler(BoardException.class)
    public String runtimeHandle(BoardException e) {
        ErrorDto response = ErrorDto.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
        return "/errors/error";
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public ErrorDto duplicateMember(SQLException e) {
        ErrorDto response = ErrorDto.builder()
                .errorCode(ErrorCode.DUPLICATE_MEMBER)
                .errorMessage("알 수 없는 에러로 회원가입이 되지 않았습니다.")
                .build();
        return response;
    }

    @ExceptionHandler(MemberException.class)
    @ResponseBody
    public ErrorDto badName(MemberException e) {
        ErrorDto response = ErrorDto.builder()
                .errorCode(ErrorCode.BAD_NAME)
                .errorMessage(ErrorCode.BAD_NAME.getMessage())
                .build();
        return response;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ErrorDto anonymousException(RuntimeException e) {
        ErrorDto response = ErrorDto.builder()
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR)
                .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
        return response;
    }
}
