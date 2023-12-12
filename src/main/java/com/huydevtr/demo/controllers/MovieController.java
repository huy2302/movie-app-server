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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> getAllShortMovie(
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<Movie> movies = movieService.findAll(pageable);
        List<ShortMovieDTO> listMovie = movies.stream()
                .map(movieToShortMovieDTO::apply)
                .collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("data", listMovie);
        response.put("metadata", "");
        return new ResponseEntity<>(response, HttpStatus.OK);
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
    @PostMapping(
            value = "/movie/create",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createMovie (@RequestBody Movie movie) {
        String abc = movieService.createMovie(movie);
        return new ResponseEntity<>(
                abc,
                HttpStatus.CREATED
        );
    }
    @GetMapping(value = "/favorite/{userID}")
    public ResponseEntity<?> getFavoritesByUserID(
            @PathVariable(value = "userID") int userID
    ) {
        List<Movie> movies = movieService.getFavoriteByUserID(userID);
        List<ShortMovieDTO> movieDTOs = movies.stream()
                .map(movieToShortMovieDTO::apply)
                .collect(Collectors.toList());
        Map<String, Object> favorites = new HashMap<>();
        favorites.put("userID", userID);
        favorites.put("movies", movieDTOs);

        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @PostMapping(value = "/update-favorite")
    public ResponseEntity<?> updateFavorite (
            @RequestParam(name = "movieID") int movieID,
            @RequestParam(name = "userID") int userID
    ) {
        int response = movieService.updateFavorite(movieID, userID);
        if (response > 0) {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "Update successfully!");
            message.put("status", HttpStatus.OK);
            message.put("number", response);
            return new ResponseEntity<>(
                    message,
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Failed",
                HttpStatus.BAD_REQUEST
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
