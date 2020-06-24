package com.example.springmockito.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class MessageServiceTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getMessage() {
        MessageService service = new MessageService();
        String actualMessage = service.getMessage();
        assertEquals("Hello!", actualMessage);
    }

    @InjectMocks
    MessageService service;
    @Mock
    MessageSource mockMessageSource;

    @Test
    void getMessageByCode() {
        doReturn("Hello!").when(mockMessageSource)
                .getMessage("greeting", null, Locale.getDefault());

        // テスト実行
        String actualMessage = service.getMessageByCode("greeting");
        assertEquals("Hello!", actualMessage);
    }
}
