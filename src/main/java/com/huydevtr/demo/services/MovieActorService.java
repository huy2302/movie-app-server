package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieActorService {
    private MovieActorRepository movieActorRepository;
    @Autowired
    public MovieActorService(MovieActorRepository movieActorRepository) {
        this.movieActorRepository = movieActorRepository;
    }
    public List<MovieActor> findAll() {
        return movieActorRepository.findAll();
    }
    public List<MovieActor> findAllByMovieID() {
        return movieActorRepository.findAllByMovieMovieID(1);
    }
}
