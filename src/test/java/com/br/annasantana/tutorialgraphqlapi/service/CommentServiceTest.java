package com.br.annasantana.tutorialgraphqlapi.service;

import com.br.annasantana.tutorialgraphqlapi.dto.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {

    private CommentService commentService;

    @BeforeEach
    public void setUp() {
        commentService = new CommentService();
    }

    @Test
    public void testCreateComment() {
        String content = "Test Content";
        String postId = "1";

        Collection<Comment> createdComments = commentService.createComment(content, postId);

        assertNotNull(createdComments);
        assertFalse(createdComments.isEmpty());
        assertTrue(createdComments.stream().anyMatch(comment -> comment.content().equals(content)));
    }

    @Test
    public void testFindByPost() {
        String postId = "1";
        String content1 = "Test Content 1";
        String content2 = "Test Content 2";
        commentService.createComment(content1, postId);
        commentService.createComment(content2, postId);

        Collection<Comment> comments = commentService.findByPost(postId);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        assertEquals(2, comments.size());
        assertTrue(comments.stream().allMatch(comment -> comment.postId().equals(postId)));
    }
}

