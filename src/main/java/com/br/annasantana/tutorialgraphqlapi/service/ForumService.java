package com.br.annasantana.tutorialgraphqlapi.service;

import com.br.annasantana.tutorialgraphqlapi.dto.Comment;
import com.br.annasantana.tutorialgraphqlapi.dto.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
class PostService {
    Map<String, Post> posts = new HashMap<>();

    Collection<Post> createPost(String content) {
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);

        return posts.values();
    };

    Post getPostById(String postId) {
        return posts.get(postId);
    };
}


@Service
class CommentService {
    Map<String, Comment> comments = new HashMap<>();

    Collection<Comment> createComment(String content, String postId){
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);

        return comments.values();
    }

    Comment getCommentById(String commentId) {
        return comments.get(commentId);
    }
}
