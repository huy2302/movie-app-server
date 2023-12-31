package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieID")
    private int movieID;
    @Column(name = "title")
    private String title; // tên movie
    @Column(name = "year")
    private String year; // năm
    @Column(name = "rated")
    private double rated; // số điểm đánh giá
    @Column(name = "released")
    private String released; // ngày ra mắt
    @Column(name = "runtime")
    private int runtime; // thời lượng phim
    @Column(name = "language")
    private String language; // ngôn ngữ
    @Column(name = "country")
    private String country; // quốc gia
    @Column(name = "awards")
    private String awards; // giải thưởng
    @Column(name = "description")
    private String description; // mô tả
    @Column(name = "poster")
    private String poster; // link poster phim

    public Movie() {
    }

    public Movie(int movieID, String title, String year, double rated, String released, int runtime, String language, String country, String awards, String description, String poster) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.description = description;
        this.poster = poster;
    }
}
