package com.tsyrkunou.react.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sport {
    @JsonProperty("id")
    private int id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("attributes")
    private Attributes attributes;
}
