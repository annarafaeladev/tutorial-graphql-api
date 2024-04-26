package com.br.annasantana.tutorialgraphqlapi.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PostDtoTest {

    private Post post;

    @BeforeEach
    void setUp () {
        this.post = new Post(UUID.randomUUID().toString(), "Test Content");
    }

    @Test
    @DisplayName("Verificar instancia Post dto ")
    public void create() {
        assertNotNull(post.id());
        assertEquals("Test Content", post.content());
    }

    @Test
    @DisplayName("Verificar hascode Post dto ")
    public void testEqualsAndHashCode() {
        Post postDTO2 = new Post(post.id(), post.content());

        assertEquals(post, postDTO2);
        assertEquals(post.hashCode(), postDTO2.hashCode());
    }


}