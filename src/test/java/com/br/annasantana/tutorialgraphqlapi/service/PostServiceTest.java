package com.br.annasantana.tutorialgraphqlapi.service;

import com.br.annasantana.tutorialgraphqlapi.dto.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class PostServiceTest {

    private PostService postService;

    @BeforeEach
    public void setUp() {
        postService = new PostService();
    }

    @Test
    public void testCreatePost() {
        String content = "Test Content";

        Collection<Post> createdPosts = postService.createPost(content);

        assertNotNull(createdPosts);
        assertFalse(createdPosts.isEmpty());
        assertTrue(createdPosts.stream().anyMatch(post -> post.content().equals(content)));
    }

    @Test
    public void testGetPostById() {
        String postId = UUID.randomUUID().toString();
        String content = "Test Content";
        postService.createPost(content);

        Post post = postService.getPostById(postId);

        assertNull(post);
    }
}
