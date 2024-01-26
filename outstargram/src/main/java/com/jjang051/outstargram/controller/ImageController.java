package com.jjang051.outstargram.controller;

import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.dto.ImageUploadDto;
import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    private final ImageService imageService;
    @GetMapping("/story")
    public String story() {
        return "image/story";
    }


    @GetMapping("/popular")
    public String popular(Model model, @PageableDefault(size = 10)Pageable pageable) {
        Page<Image> imageList = imageService.popular(pageable);
        model.addAttribute("imageList",imageList);
        return "image/popular";
    }


    @GetMapping("/upload")
    public String upload() {
        return "image/upload";
    }

    @PostMapping("/upload")
    public String uploadProcess(ImageUploadDto imageUploadDto,
                                @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        log.info("imageUploadDto==={}",imageUploadDto.getCaption());
        log.info("imageUploadDto==={}",imageUploadDto.getFile());
        imageService.upload(imageUploadDto,customUserDetails);
        return "redirect:/member/mypage/"+customUserDetails.getLoggedMember().getId();
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model) {
        Image imageInfo = imageService.loadDetail(id);
        model.addAttribute("imageInfo",imageInfo);
        log.info("imageInfo===={}",imageInfo.toString());
        return "image/detail";
    }
}
