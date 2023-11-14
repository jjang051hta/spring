package com.jjang051.gallery.controller;

import com.jjang051.gallery.dto.GalleryDto;
import com.jjang051.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/gallery")
@Slf4j
@Controller
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;

    @GetMapping("/insert")
    public String insertGallery() {
        return "/gallery/insert";
    }
    @PostMapping("/insert")
    @ResponseBody
    public String insertGalleryProcess(@ModelAttribute GalleryDto galleryDto) {
        int result = galleryService.insertGallery(galleryDto);
        return "/";
    }
}
