package com.huydevtr.demo.services.mapper;

import com.huydevtr.demo.models.DTOentities.MovieDTO;
import com.huydevtr.demo.models.DTOentities.ShortMovieDTO;
import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.repositories.ActorRepository;
import com.huydevtr.demo.repositories.MovieActorRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MovieToShortMovieDTO implements Function<Movie, ShortMovieDTO> {
    @Override
    public ShortMovieDTO apply(Movie movie) {
        return new ShortMovieDTO(
               movie.getMovieID(),
               movie.getTitle(),
               movie.getPoster(),
               movie.getYear(),
               movie.getCountry(),
               movie.getRated(),
               movie.getRuntime(),
               movie.getGenreList().stream().map(genre -> genre.getGenre()).collect(Collectors.toList())
        );
    }
}