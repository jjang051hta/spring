package com.jjang051.outstargram.api;

import com.jjang051.outstargram.dto.CommentDto;
import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.entity.Comments;
import com.jjang051.outstargram.service.CommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CommentsApiController {
    private final CommentsService commentsService;
    @PostMapping("/comment")
    public Map<String, Object> saveComment(CommentDto commentDto,
                                   @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Comments comments = commentsService.saveComment(
                commentDto.getContent(),
                commentDto.getImageId(),
                customUserDetails.getLoggedMember().getId()
                );
        Map<String,Object> resultMap = new HashMap<>();
        log.info("commentDto==={}",commentDto);
        resultMap.put("insert","ok");
        resultMap.put("comments",comments);
        return resultMap;
    }
}
