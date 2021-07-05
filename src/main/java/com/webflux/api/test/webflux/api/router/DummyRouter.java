package com.webflux.api.test.webflux.api.router;

import com.webflux.api.test.webflux.api.handler.DummyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class DummyRouter {


    @Bean
    public RouterFunction<ServerResponse> dummyRoutes(DummyHandler dummyHandler){
        return
                        RouterFunctions
                                .route()
                                .path("/api",
                                        builder
                                                -> builder
                                                .GET(
                                                        "/dummy",
                                                        dummyHandler::postDummy
                                                )
                                                //.POST("/dummy", dummyHandler::postDummy)
                                        .build()
                                )
                                .build();
    }
}
