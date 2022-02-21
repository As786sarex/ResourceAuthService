package com.levelfancy.repository.impl;

import com.levelfancy.models.ChatMessage;
import com.levelfancy.repository.AuthRepository;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class InMemoryAuthRepository implements AuthRepository {

    private final Map<String, ChatMessage> authTable;

    public InMemoryAuthRepository() {
        this.authTable = new ConcurrentHashMap<>();
        this.authTable.put("from1", new ChatMessage("from1", "text1", LocalDateTime.now()));
        this.authTable.put("from2", new ChatMessage("from2", "text2", LocalDateTime.now()));
        this.authTable.put("from3", new ChatMessage("from3", "text3", LocalDateTime.now()));
    }

    @Override
    public Optional<ChatMessage> save(ChatMessage chatMessage) {
        if (this.authTable.containsKey(chatMessage.getFrom())) {
            throw new IllegalStateException("User already exists");
        }
        this.authTable.put(chatMessage.getFrom(), chatMessage);
        return Optional.of(this.authTable.get(chatMessage.getFrom()));
    }

    @Override
    public Collection<ChatMessage> getAll() {
        return authTable.values();
    }

    @Override
    public Optional<ChatMessage> getById(String id) {
        if (this.authTable.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(this.authTable.get(id));
    }


}
