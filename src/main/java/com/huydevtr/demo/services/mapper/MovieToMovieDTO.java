package com.huydevtr.demo.services.mapper;

import com.huydevtr.demo.models.DTOentities.MovieDTO;
import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.repositories.ActorRepository;
import com.huydevtr.demo.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class MovieToMovieDTO implements Function<Movie, MovieDTO> {
    @Autowired
    MovieActorRepository movieActorRepository;
    @Autowired
    ActorRepository actorRepository;
    public List<String> getListActorByMovieID(int movieID) {
        List<MovieActor> movieActors =  movieActorRepository.findAllByMovieMovieID(movieID);

        List<String> listActor = new ArrayList<>();
        movieActors.forEach(movieActor -> {
            Actor actor = actorRepository.findById(movieActor.getActor().getActorID());
            listActor.add(actor.getActorName());
        });

        return listActor;
    }
    @Override
    public MovieDTO apply(Movie movie) {
        return new MovieDTO(
                movie.getMovieID(),
                movie.getTitle(),
                movie.getYear(),
                movie.getRated(),
                movie.getReleased(),
                movie.getRuntime(),
                getListActorByMovieID(movie.getMovieID()),
                movie.getDescription(),
                movie.getLanguage(),
                movie.getCountry(),
                movie.getAwards(),
                movie.getPoster()
        );
    }
}
