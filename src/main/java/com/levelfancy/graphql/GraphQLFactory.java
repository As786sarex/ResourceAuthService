package com.levelfancy.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Factory
@Slf4j
public class GraphQLFactory {

    @Bean
    @Singleton
    public GraphQL getGraphQL(final ResourceResolver resourceResolver,final AuthDataFetchers authDataFetchers) {
        var schemaParser = new SchemaParser();

        var typeRegistry = new TypeDefinitionRegistry();
        var graphqlSchema = resourceResolver.getResourceAsStream("classpath:graphql/schema.graphqls");
        if (graphqlSchema.isEmpty()) {
            log.debug("No graphql schema found");
            return GraphQL.newGraphQL(GraphQLSchema.newSchema().build()).build();
        }
        typeRegistry.merge(schemaParser.parse(new BufferedReader(new InputStreamReader(graphqlSchema.get()))));
        var runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("QueryRoot").dataFetcher("messages", authDataFetchers.getChatDataFetcher()))
                .build();
        var schemaGenerator = new SchemaGenerator();
        var graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
}
