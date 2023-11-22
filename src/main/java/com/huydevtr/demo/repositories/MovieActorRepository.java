package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface MovieActorRepository extends JpaRepository<MovieActor, Integer> {
    List<MovieActor> findAllByMovieMovieID(int movieID);
}
