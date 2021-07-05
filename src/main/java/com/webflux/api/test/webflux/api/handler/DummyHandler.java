package com.webflux.api.test.webflux.api.handler;

import com.webflux.api.test.webflux.api.model.Book;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DummyHandler {
    public Mono<ServerResponse> postDummy(ServerRequest serverRequest) {


        WebClient webClient = WebClient.builder().build();

        final var books =
                webClient
                        .get()
                        .uri("http://localhost:8082/")
                        .retrieve()
                        .bodyToFlux(Book.class);


        return
                ServerResponse
                        .ok()
                        .body(
                                books,
                                Book.class
                        );

    }
}
