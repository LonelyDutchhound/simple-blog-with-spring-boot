package com.lonelydutchhound.blog.controllers;

import com.lonelydutchhound.blog.models.BlogPost;
import com.lonelydutchhound.blog.services.BlogPostManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    BlogPostManagingService postManagingService;

    @GetMapping("/blog/{id}")
    public String showFullPostText(@PathVariable(value="id") long id, Model model) {
        ArrayList<BlogPost> blogPostArray = postManagingService.getBlogPostById(id);
        if (blogPostArray.isEmpty()) {
            return "no-post-found";
        }
        model.addAttribute("blogPost", blogPostArray);
        return "blog-post";
    }

    @GetMapping("/blog/{id}/edit")
    public String openEditor(@PathVariable(value="id") long id, Model model) {
        ArrayList<BlogPost> blogPostArray = postManagingService.getBlogPostById(id);
        if (blogPostArray.isEmpty()) {
            return "no-post-found";
        }
        model.addAttribute("blogPost", blogPostArray);
        return "blog-post-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String text) {
        postManagingService.editBlogPost(id, title, text);
        return "redirect:/blog/" + id;
    }

    @PostMapping("/blog/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postManagingService.deleteBlogPost(id);
        return "redirect:/home";

    }
}
