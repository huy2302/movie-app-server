package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.DTO.MovieMapper;
import com.huydevtr.demo.models.DTOentities.GenreDTO;
import com.huydevtr.demo.models.DTOentities.MovieDTO;
import com.huydevtr.demo.models.DTOentities.ShortMovieDTO;
import com.huydevtr.demo.models.entities.Genre;
import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.models.entities.MovieActor;
import com.huydevtr.demo.services.GenreService;
import com.huydevtr.demo.services.MovieService;
import com.huydevtr.demo.services.mapper.GenreToGenreDTO;
import com.huydevtr.demo.services.mapper.MovieToMovieDTO;
import com.huydevtr.demo.services.mapper.MovieToShortMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieToMovieDTO movieToMovieDTO;
    @Autowired
    private MovieToShortMovieDTO movieToShortMovieDTO;
    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreToGenreDTO genreToGenreDTO;
    @Autowired
    MovieMapper movieMapper;

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
    // get phim chi tiết
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
    //    get danh sách phim dạng shortMovie
    @GetMapping("/movies")
    public ResponseEntity<List<ShortMovieDTO>> getAllShortMovie(
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<Movie> movies = movieService.findAll(pageable);
        List<ShortMovieDTO> productDTOs = movies.stream()
                .map(movieToShortMovieDTO::apply)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
//    get danh sách thể loại
    @GetMapping("/genres")
    public ResponseEntity<List<GenreDTO>> getAllGenre() {
        List<Genre> genres = genreService.findAll();
        List<GenreDTO> genreDTOS = genres.stream()
                .map(genreToGenreDTO::apply)
                .collect(Collectors.toList());
        return new ResponseEntity<>(
                genreDTOS,
                HttpStatus.OK
        );
    }
//    @GetMapping("/movies")
//    public ResponseEntity<List<MovieDTO>> getAllMovie(
//            @RequestParam(defaultValue = "0") int page
//    ) {
//        Pageable pageable = PageRequest.of(page, 10);
//
//        Page<Movie> movies = movieService.findAll(pageable);
//        List<MovieDTO> productDTOs = movies.stream()
//                .map(movieToMovieDTO::apply)
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
//    }
}
