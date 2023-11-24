package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    public Movie findByID(int movieID) {
        Optional<Movie> result = movieRepository.findById(movieID);

        Movie movie = null;

        if (result.isPresent()) {
            movie = result.get();
        } else {
            throw new RuntimeException("Did not find product id - " + movieID);
        }

        return movie;
    }
}
