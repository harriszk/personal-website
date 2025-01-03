package com.zachary.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zachary.backend.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}