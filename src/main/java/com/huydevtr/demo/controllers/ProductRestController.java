package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.DTO.MovieMapper;
import com.huydevtr.demo.models.DTOentities.MovieDTO;
import com.huydevtr.demo.models.Product;
import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.services.MovieActorService;
import com.huydevtr.demo.services.MovieService;
import com.huydevtr.demo.services.ProductService;
import com.huydevtr.demo.services.mapper.MovieToMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieActorService movieActorService;
    @Autowired
    private MovieToMovieDTO movieToMovieDTO;
    @Autowired
    MovieMapper movieMapper;
    @GetMapping("/mov")
    public ResponseEntity<List<MovieActor>> movieActors () {
        List<MovieActor> actors = movieActorService.findAll();

        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
//    @GetMapping("/movie/{id}")
//    public ResponseEntity<MovieDTO> getMovieDetails (
//            @PathVariable(value = "id") int id
//    ) {
//        return new ResponseEntity<>(
//                movieMapper.movieToMovieDetails(
//                    movieService.findByID(id)
//                ),
//                HttpStatus.OK
//        );
//    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovieDetails (
            @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(
                movieToMovieDTO.apply(
                    movieService.findByID(id)
                ),
                HttpStatus.OK
        );
    }
    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTO>> getAllMovie() {
        List<Movie> movies = movieService.findAll();
        List<MovieDTO> productDTOs = movies.stream()
                .map(movieToMovieDTO::apply)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
}
