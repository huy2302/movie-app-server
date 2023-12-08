package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.movieID = :movieID")
    Optional<Movie> findByMovieId(@Param("movieID") int movieID);
    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    Optional<Movie> findByTitle(@Param("title") String title);
}
