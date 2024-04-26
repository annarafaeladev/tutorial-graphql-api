package com.br.annasantana.tutorialgraphqlapi.controller;

import com.br.annasantana.tutorialgraphqlapi.dto.Comment;
import com.br.annasantana.tutorialgraphqlapi.dto.Post;
import com.br.annasantana.tutorialgraphqlapi.service.CommentService;
import com.br.annasantana.tutorialgraphqlapi.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumControllerTest {

    @Mock
    private PostService postService;

    @Mock
    private CommentService commentService;

    @InjectMocks
    private ForumController forumController;

    private Post post;

    private Comment comment;

    @BeforeEach
    void setUp () {
        this.post = new Post(UUID.randomUUID().toString(), "Test Content");
        this.comment = new Comment(UUID.randomUUID().toString(), "Test Comentario", this.post.id());
    }

    @Test
    @DisplayName("Teste criar post")
    public void testCreatePost() {
        when(postService.createPost(anyString())).thenReturn(Collections.singletonList(post));

        Collection<Post> result = forumController.createPost(post.content());

        assertEquals(1, result.size());
        verify(postService, times(1)).createPost(anyString());
    }

    @Test
    @DisplayName("Teste buscar post por id")
    public void testPostById() {
        when(postService.getPostById(anyString())).thenReturn(post);

        Post result = forumController.postById(post.id());

        assertNotNull(result);
        verify(postService, times(1)).getPostById(anyString());
    }

    @Test
    @DisplayName("Teste criar comentario para um postId")
    public void testCreateComment() {
        when(commentService.createComment(anyString(), anyString())).thenReturn(Collections.singletonList(comment));

        Collection<Comment> result = forumController.createComment(comment.content(), comment.postId());

        assertEquals(1, result.size());
        verify(commentService, times(1)).createComment(anyString(), anyString());
    }

    @Test
    @DisplayName("Teste carregar comentario por postId")
    public void testComments() {
        when(commentService.findByPost(anyString())).thenReturn(Collections.singletonList(comment));

        Collection<Comment> result = forumController.comments(post);

        assertEquals(1, result.size());
        verify(commentService, times(1)).findByPost(anyString());
    }

}
