package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie_actor")
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @MapsId("movieID")
    @JoinColumn(name = "movieID")
    Movie movie;

    @ManyToOne
    @MapsId("actorID")
    @JoinColumn(name = "actorID")
    Actor actor;

    public MovieActor() {
    }

    public MovieActor(int id, Movie movie, Actor actor) {
        this.id = id;
        this.movie = movie;
        this.actor = actor;
    }
}
