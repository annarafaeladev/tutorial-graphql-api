package com.br.annasantana.tutorialgraphqlapi.controller;

import com.br.annasantana.tutorialgraphqlapi.dto.Post;
import com.br.annasantana.tutorialgraphqlapi.dto.Comment;
import com.br.annasantana.tutorialgraphqlapi.service.CommentService;
import com.br.annasantana.tutorialgraphqlapi.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ForumController {

    private final PostService postService;
    private final CommentService commentService;

    public ForumController(PostService postService, CommentService commentService){
        this.postService = postService;s
        this.commentService = commentService;
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

    @SchemaMapping(typeName = "Query", value = "postById") // ou @QueryMapping
    public Post postById(@Argument String id) {
        return postService.getPostById(id);
    }

   @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }
}
