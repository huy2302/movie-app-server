package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreID")
    private int GenreID;
    @Column(name = "genre")
    private String Genre; // tên thể loại

    public Genre() {
    }

    public Genre(int genreID, String genre) {
        GenreID = genreID;
        Genre = genre;
    }
}
