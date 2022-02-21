package com.levelfancy.repository;

import com.levelfancy.models.ChatMessage;
import io.micronaut.core.annotation.NonNull;

import java.util.Collection;
import java.util.Optional;

public interface AuthRepository {
    Optional<ChatMessage> save(@NonNull ChatMessage chatMessage);
    @NonNull
    Collection<ChatMessage> getAll();
    Optional<ChatMessage> getById(@NonNull String id);
}
