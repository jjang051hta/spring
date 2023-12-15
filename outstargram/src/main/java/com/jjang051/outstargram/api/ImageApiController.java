package com.jjang051.outstargram.api;

import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageApiController {

    private final ImageService imageService;
    @GetMapping("/image")
    public Map<String, Object> loadStroy(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Map<String,Object> resultMap = new HashMap<>();
        List<Image> imageList = imageService.loadStory(customUserDetails.getLoggedMember().getId());
        resultMap.put("imageList",imageList);
        return resultMap;
    }
}
