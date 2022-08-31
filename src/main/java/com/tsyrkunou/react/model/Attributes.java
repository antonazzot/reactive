package com.tsyrkunou.react.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("parent_id")
    private Long parentId;
    @JsonProperty("decathlon_id")
    private Long decathlonId;
    @JsonProperty("locale")
    private String locale;
}
