package com.jjang051.isotope.controller;

import com.jjang051.isotope.dto.CustomUserDetails;
import com.jjang051.isotope.dto.MemberDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.extras.springsecurity6.auth.Authorization;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getPrincipal();
        if(customUserDetails!=null) {
            MemberDto loggedMember = customUserDetails.getLoggedMember();
            model.addAttribute("loggedMember",loggedMember);
        }
        return "/index";
    }
}
