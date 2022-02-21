package com.levelfancy.configuration;

import io.micronaut.context.annotation.Bean;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

@Singleton
public class DynamoDbConfig {

    @Bean
    @Singleton
    public DynamoDbClient asyncClient() {
        return DynamoDbClient.builder()
                .credentialsProvider(getCredentialProvider())
                .build();
    }

    @NonNull
    private AwsCredentialsProvider getCredentialProvider() {
        return DefaultCredentialsProvider.builder()
                .build();
    }
}
