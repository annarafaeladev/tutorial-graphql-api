package com.br.annasantana.tutorialgraphqlapi.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentDtoTest {

    private Post post;

    private Comment comment;

    @BeforeEach
    void setUp () {
        this.post = new Post(UUID.randomUUID().toString(), "Test Content");
        this.comment = new Comment(UUID.randomUUID().toString(), "Test Comentario", this.post.id());
    }

    @Test
    @DisplayName("Verificar instancia Comment dto ")
    public void create() {
        assertNotNull(comment.id());
        assertEquals(post.id(), comment.postId());
        assertEquals("Test Comentario", comment.content());
    }

    @Test
    @DisplayName("Verificar hascode Comment dto ")
    public void testEqualsAndHashCode() {
        Comment comment2 = new Comment(comment.id(), comment.content(), comment.postId());

        assertEquals(comment, comment2);
        assertEquals(comment.hashCode(), comment2.hashCode());
    }


}