package com.tsyrkunou.react.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tsyrkunou.react.service.MonoService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyRouter {
    private final MonoService monoService;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router", monoService::loadSports)
                .GET("/router/{name}", monoService::searchByName)
                .POST("/router/save", monoService::saveSport)
                .build();
    }
}
