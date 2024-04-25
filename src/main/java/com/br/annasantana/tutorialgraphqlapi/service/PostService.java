package com.br.annasantana.tutorialgraphqlapi.service;

import com.br.annasantana.tutorialgraphqlapi.dto.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {
    Map<String, Post> posts = new HashMap<>();

    public Collection<Post> createPost(String content) {
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);

        return posts.values();
    };

    public Post getPostById(String postId) {
        return posts.get(postId);
    };
}


