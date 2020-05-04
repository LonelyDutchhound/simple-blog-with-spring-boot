package com.lonelydutchhound.blog.services;

import com.lonelydutchhound.blog.interfaces.TextGenerator;
import com.lonelydutchhound.blog.models.BlogPost;
import com.lonelydutchhound.blog.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BlogPostManagingService {

    @Autowired
    private TextGenerator shortcutGeneratorService;

    @Autowired
    private BlogPostRepository blogPostRepository;

    public Iterable<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public ArrayList<BlogPost> getBlogPostById(long id) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        ArrayList<BlogPost> blogPostArray = new ArrayList<>();
        blogPost.ifPresent(blogPostArray::add);
        return blogPostArray;
    }

    public void createNewBlogPost(String title, String text) {
        String shortcut = shortcutGeneratorService.generateText(text);
        BlogPost post = new BlogPost(title, shortcut, text);
        blogPostRepository.save(post);
    }

    public void editBlogPost(long id, String title, String text) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        if (blogPost.isPresent()) {
           BlogPost post = blogPost.get();
            String shortcut = shortcutGeneratorService.generateText(text);
           post.setTitle(title);
           post.setShortcut(shortcut);
           post.setFullText(text);
           blogPostRepository.save(post);
        }
    }

    public void deleteBlogPost(long id) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        if (blogPost.isPresent()) {
            BlogPost post = blogPost.get();
            blogPostRepository.delete(post);
        }
    }
}
