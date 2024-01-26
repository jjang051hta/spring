package com.jjang051.outstargram.api;

import com.jjang051.outstargram.dto.CommentDto;
import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.entity.Comments;
import com.jjang051.outstargram.service.CommentsService;
import com.jjang051.outstargram.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/comment/{id}")
    public Map<String, Object> deleteComment(@PathVariable int id) {
        commentsService.deleteComment(id);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("delete","ok");
        return resultMap;
    }
    //@PreAuthorize({"ROLE_USER", "ROLE_ADMIN"})
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/message/{id}")
    public String sendMessage(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                            @PathVariable Long id
                           ) {
        if(customUserDetails!=null) {
            return "aa";
        }
        return "bb";
    }
}
