package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenreDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name") // genre name
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
