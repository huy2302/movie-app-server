package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(mappedBy = "genreList", fetch = FetchType.LAZY)
    private List<Movie> movieList;
    public Genre() {
    }

    public Genre(int genreID, String genre) {
        GenreID = genreID;
        Genre = genre;
    }
}
