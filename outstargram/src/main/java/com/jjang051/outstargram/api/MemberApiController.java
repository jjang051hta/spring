package com.jjang051.outstargram.api;

import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.dto.SubscribeDto;
import com.jjang051.outstargram.entity.Member;
import com.jjang051.outstargram.service.MemberService;
import com.jjang051.outstargram.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MemberApiController {
    private final MemberService memberService;
    private final SubscribeService subscribeService;


    @PutMapping("/member/{id}/profileImageUrl")
    public Map<String,Object> profileImageUpdate(@PathVariable int id,
                                                 MultipartFile profileImageUrl) {
        log.info("profileImageUrl==={}",profileImageUrl);
        Member memberInfo = memberService.changeProfile(id, profileImageUrl); //void
        log.info(memberInfo.toString());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("isState","ok");
        resultMap.put("memberInfo",memberInfo);

        return resultMap;
    }

    @GetMapping("/member/{urlId}/subscribe")
    public Map<String, Object> subscribeList(
                    @AuthenticationPrincipal CustomUserDetails customUserDetails,
                    @PathVariable int urlId) {
        List<SubscribeDto> subscribeList = subscribeService.subscribeList(
                customUserDetails.getLoggedMember().getId(),urlId);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("subscribeList",subscribeList);
        return  resultMap;
    }
}
