package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huydevtr.demo.models.entities.Director;
import com.huydevtr.demo.models.entities.Writer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {
    @JsonProperty("MovieID")
    private int MovieID;
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private String Year;
    @JsonProperty("Rated")
    private double Rated;
    @JsonProperty("Released")
    private String Released;
    @JsonProperty("Runtime")
    private int Runtime;
    @JsonProperty("Genre")
    private String Genre;
    @JsonProperty("Directors")
    private List<String> Directors;
    @JsonProperty("Writers")
    private List<String> Writers;
    @JsonProperty("Actors")
    private List<String> Actors;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Language")
    private String Language;
    @JsonProperty("Country")
    private String Country;
    @JsonProperty("Awards")
    private String Awards;
    @JsonProperty("Poster")
    private String Poster;

    public MovieDTO() {
    }

    public MovieDTO(int movieID, String title, String year, double rated, String released, int runtime, List<String> directors, List<String> writers, List<String> actors, String description, String language, String country, String awards, String poster) {
        MovieID = movieID;
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Directors = directors;
        Writers = writers;
        Actors = actors;
        Description = description;
        Language = language;
        Country = country;
        Awards = awards;
        Poster = poster;
    }
}
