package com.lonelydutchhound.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPageController {

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
