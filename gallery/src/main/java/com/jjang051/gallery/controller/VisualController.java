package com.jjang051.gallery.controller;

import com.jjang051.gallery.dto.VisualDto;
import com.jjang051.gallery.service.VisualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visual")
@RequiredArgsConstructor
public class VisualController {

    private final VisualService visualService;

    @GetMapping("/insert")
    public String insert() {
        return "/visual/insert";
    }
    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute VisualDto visualDto) {
        int result = visualService.insertVisual(visualDto);
        return "/visual/list";
    }
}
