package com.levelfancy.repository.impl;

import com.levelfancy.models.ChatMessage;
import com.levelfancy.repository.AuthRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DynamoDbAuthRepository implements AuthRepository {
    private final DynamoDbClient dynamoDbClient;


    @Override
    public Optional<ChatMessage> save(ChatMessage chatMessage) {
        return Optional.empty();
    }

    @Override
    public Collection<ChatMessage> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Optional<ChatMessage> getById(String id) {
        return Optional.empty();
    }
}
