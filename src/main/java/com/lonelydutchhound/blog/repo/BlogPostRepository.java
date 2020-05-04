package com.lonelydutchhound.blog.repo;

import com.lonelydutchhound.blog.models.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
}
