package com.lonelydutchhound.blog.controllers;

import com.lonelydutchhound.blog.models.BlogPost;
import com.lonelydutchhound.blog.services.BlogPostManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    BlogPostManagingService postManagingService;

    @GetMapping({"/","/home"})
    public String getAllPosts(Model model) {
        Iterable<BlogPost> blogPosts = postManagingService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "home";
    }

    @GetMapping("add-post")
    public String addPost() {
        return "blog-post-add";
    }

    @PostMapping("/blog/add")
    public String addPost(@RequestParam String title, @RequestParam String text) {
        postManagingService.createNewBlogPost(title, text);
        return "redirect:/home";
    }

}
