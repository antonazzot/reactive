package com.tsyrkunou.react.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    @JsonProperty("data")
    private List<Sport> sports;
}
