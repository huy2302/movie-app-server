package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huydevtr.demo.models.entities.Director;
import com.huydevtr.demo.models.entities.Writer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {
    @JsonProperty("movieID")
    private int movieID;
    @JsonProperty("title")
    private String title;
    @JsonProperty("poster")
    private String poster;
    @JsonProperty("year")
    private String year;
    @JsonProperty("rated")
    private double rated;
    @JsonProperty("released")
    private String released;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("directors")
    private List<String> directors;
    @JsonProperty("writers")
    private List<String> writers;
    @JsonProperty("actors")
    private List<String> actors;
    @JsonProperty("plot")
    private String plot;
    @JsonProperty("country")
    private String country;
    @JsonProperty("awards")
    private String awards;
    @JsonProperty("language")
    private String language;
    @JsonProperty("genres")
    private List<String> genres;

    public MovieDTO() {
    }

    public MovieDTO(int movieID, String title, String year, double rated, String released, int runtime, List<String> genres, List<String> directors, List<String> writers, List<String> actors, String plot, String language, String country, String awards, String poster) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
    }
}
