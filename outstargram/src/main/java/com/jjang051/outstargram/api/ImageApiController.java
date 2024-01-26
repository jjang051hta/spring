package com.jjang051.outstargram.api;

import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.service.ImageService;
import com.jjang051.outstargram.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageApiController {

    private final ImageService imageService;
    private final LikesService likesService;
    @GetMapping("/image")
    public Map<String, Object> loadStroy(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PageableDefault(size = 3)Pageable pageable
            ) {
        Map<String,Object> resultMap = new HashMap<>();
        Page<Image> imageList = imageService.loadStory(customUserDetails.getLoggedMember().getId(),pageable);
        resultMap.put("imageList",imageList);
        return resultMap;
    }

    // /api/images/1/likes
    @PostMapping("/image/{imageId}/likes")
    public Map<String,Object> likes(@PathVariable int imageId,
                                    @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        int result = likesService.like(imageId,customUserDetails.getLoggedMember().getId());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("like","ok");
        return resultMap;
    }

    @DeleteMapping("/image/{imageId}/likes")
    public Map<String,Object> hate(@PathVariable int imageId,
                                    @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        int result = likesService.hate(imageId,customUserDetails.getLoggedMember().getId());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("hate","ok");
        return resultMap;
    }

    @GetMapping("/image/popular")
    public Map<String, Object> popular(Model model, @PageableDefault(size = 10)Pageable pageable) {
        Page<Image> imageList = imageService.popular(pageable);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("imageLis",imageList);
        //model.addAttribute("imageList",imageList);
        return resultMap;
    }



}
