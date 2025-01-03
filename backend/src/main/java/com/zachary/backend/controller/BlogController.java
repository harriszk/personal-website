package com.zachary.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zachary.backend.model.Post;
import com.zachary.backend.service.PostService;

@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RestController
public class BlogController {
    private PostService postService;

    @Autowired
    public BlogController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Get all of the posts.
     * 
     * @return List<Post> All of the posts.
     */
    @GetMapping("/posts")
    public List<Post> getAllPosts(
        @RequestParam(required = false) String id,
        @RequestParam(required = false) String author
    ) {
        if (id != null) {
            return this.postService.getPostById(Long.parseLong(id));
        }
        
        return this.postService.getAllPosts();
    }

    /**
     * Create a new post.
     * 
     * @param post The post to create.
     * @return Post The created post.
     */
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return this.postService.createPost(post);
    }

    /**
     * Update an existing post.
     * 
     * @param post The post to update.
     * @return Post The updated post.
     */
    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post post) {
        return this.postService.updatePost(post);
    }

    /**
     * Delete a post.
     * 
     * @param id
     */
    @DeleteMapping("/posts")
    public void deletePost(@RequestParam Long id) {
        this.postService.deletePost(id);
    }

    /**
     * Publish a post.
     * 
     * @param id
     * @return Post
     */
    @PostMapping("/posts/{id}/publish")
    public Post publishPost(@PathVariable Long id) {
        return this.postService.publishPost(id);
    }

    /**
     * Unpublish a post.
     * 
     * @param id
     * @return Post
     */
    @PostMapping("/posts/{id}/unpublish")
    public Post unpublishPost(@PathVariable Long id) {
        return this.postService.unpublishPost(id);
    }
}
