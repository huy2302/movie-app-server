package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShortMovieDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("poster")
    private String poster;
    @JsonProperty("year")
    private String year;
    @JsonProperty("country")
    private String country;
    @JsonProperty("rating")
    private double rating;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("Genre")
    private List<String> genres;
    @JsonProperty("images")
    private List<String> images;

    public ShortMovieDTO() {
    }

    public ShortMovieDTO(int id, String title, String poster, String year, String country, double rating, int runtime, List<String> genres) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.year = year;
        this.country = country;
        this.rating = rating;
        this.runtime = runtime;
        this.genres = genres;
    }
}
