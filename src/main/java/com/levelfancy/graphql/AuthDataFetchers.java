package com.levelfancy.graphql;

import com.levelfancy.models.ChatMessage;
import com.levelfancy.repository.AuthRepository;
import graphql.schema.DataFetcher;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Collection;

@Singleton
public class AuthDataFetchers {

    private final AuthRepository authRepository;

    @Inject
    public AuthDataFetchers(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public DataFetcher<Collection<ChatMessage>> getChatDataFetcher() {
        return environment -> authRepository.getAll();
    }
}
