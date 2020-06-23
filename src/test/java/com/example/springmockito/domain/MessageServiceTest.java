package com.example.springmockito.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Test
    void getMessage() {
        MessageService service = new MessageService();
        String actualMessage = service.getMessage();
        assertEquals("Hello!", actualMessage);
    }
}
