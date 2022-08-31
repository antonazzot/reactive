package com.tsyrkunou.react.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.tsyrkunou.react.model.Data;
import com.tsyrkunou.react.model.Sport;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class SportDao {
    private final WebClient webClient;
    private final String URI = "https://sports.api.decathlon.com/sports";

    @SneakyThrows
    public Flux<Sport> parseJson() {
        return webClient.get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Data.class)
                .map(Data::getSports)
                .flatMapMany(Flux::fromIterable).log();
    }

    @SneakyThrows
    public Mono<Sport> parseMonoSport() {
        return webClient.get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Data.class)
                .map(Data::getSports)
                .flatMapMany(Flux::fromIterable).log()
                .next();
    }

    @SneakyThrows
    public List<Sport> sportsList() {
        return webClient.get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Data.class)
                .map(Data::getSports).toFuture().getNow(new ArrayList<>());
    }

    @SneakyThrows
    public Flux<Sport> getWithRange() {
        return webClient.get()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Data.class)
                .map(Data::getSports)
                .flatMapMany(Flux::fromIterable).log()
                .doOnNext(sport -> Flux.range(1, 20));
    }


    public Sport saveSport(Sport sport) {
        if (!sportsList().contains(sport)) {
            System.out.println(sport.toString() + " saved");
        } else {
            throw new RuntimeException("duplicate");
        }
        return sport;
    }
}