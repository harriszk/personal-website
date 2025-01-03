package com.zachary.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zachary.backend.model.Post;
import com.zachary.backend.repository.PostRepository;

@Component
public class PostService {
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Get all of the posts.
     * 
     * @return
     */
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    /**
     * Get a post by its ID.
     * 
     * @param id
     * @return
     */
    public List<Post> getPostById(Long id) {
        return List.of(postRepository.findById(id).orElse(null));
    }

    /**
     * Create a new post.
     * 
     * @param post
     * @return
     */
    public Post createPost(Post post) {
        Long id = post.getId();

        if (id != null && postRepository.existsById(id)) {
            return null;
        }

        return postRepository.save(post);
    }

    /**
     * Update an existing post.
     * 
     * @param post
     * @return
     */
    public Post updatePost(Post post) {
        Long id = post.getId();

        if (id == null || !postRepository.existsById(id)) {
            return null;
        }

        return postRepository.save(post);
    }

    /**
     * Delete a post.
     * 
     * @param id
     */
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            return;
        }
        
        postRepository.deleteById(id);
    }

    /**
     * Publish a post.
     * 
     * @param id
     * @return
     */
    public Post publishPost(Long id) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null || post.isPublished()) {
            return null;
        }

        post.setPublished(true);
        return postRepository.save(post);
    }

    /**
     * Unpublish a post.
     * 
     * @param id
     * @return
     */
    public Post unpublishPost(Long id) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null || !post.isPublished()) {
            return null;
        }

        post.setPublished(false);
        return postRepository.save(post);
    }
}
