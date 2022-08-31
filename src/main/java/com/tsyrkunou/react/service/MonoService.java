package com.tsyrkunou.react.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tsyrkunou.react.dao.SportDao;
import com.tsyrkunou.react.model.Sport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonoService {
    private final SportDao sportDao;

    public Mono<ServerResponse> loadSports(ServerRequest serverRequest) {
        return ServerResponse.ok().body(sportDao.parseJson(), Sport.class);
    }

    public Mono<ServerResponse> searchByName(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        Mono<Sport> next = sportDao.parseJson().filter(sport -> sport.getAttributes().getName().equals(name)).next();
        return ServerResponse.ok().body(next, Sport.class);
    }

    public Mono<ServerResponse> saveSport(ServerRequest serverRequest) {
        Mono<Sport> sportMono = serverRequest.bodyToMono(Sport.class);
        Mono<Sport> res = sportMono.map(sportDao::saveSport).doOnError(e -> log.error(e.getMessage()));
        return ServerResponse.ok().body(res, Sport.class);
    }
}
