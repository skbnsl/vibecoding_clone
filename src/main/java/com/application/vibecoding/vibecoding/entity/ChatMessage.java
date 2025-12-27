package com.application.vibecoding.vibecoding.entity;

import com.application.vibecoding.vibecoding.enums.MessageRole;

import java.time.Instant;

public class ChatMessage {

    Long id;

    ChatSession chatSession;
    String content;

    String toolCalls;

    MessageRole role;

    Integer tokenUsed;
    Instant createdAt;
}
