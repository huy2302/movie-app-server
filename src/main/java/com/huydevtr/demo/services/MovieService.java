package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.*;
import com.huydevtr.demo.repositories.MovieRepository;
import com.huydevtr.demo.repositories.UserRepository;
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
//    @Autowired
//    FavoriteRepository favoriteRepository;
    @Autowired
    UserRepository userRepository;

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

    public String createMovie (Movie movie) {
        Optional<Movie> existingMovieId = movieRepository.findByMovieId(movie.getMovieID());
        Optional<Movie> existingMovieTitle = movieRepository.findByTitle(movie.getTitle());

        if (existingMovieId.isPresent() || existingMovieTitle.isPresent()) {
            return "Movie with title '" + movie.getTitle() + "' already exists!";
        }
//        movieRepository.save(movie);
        return "Save movie successfully!";
    }
    public List<Movie> findMoviesByMovieTitle(String movieTitle) {
        return movieRepository.findMovieByMovieTitle(movieTitle);
    }
    public List<Movie> getFavoriteByUserID(int userID) {
        return movieRepository.findMovieOnFavoriteByUserID(userID);
    }
    public int updateFavorite (int movieID, int userID) {
        Optional<Movie> existingMovie = movieRepository.checkEmptyFavorite(movieID, userID);
//        Movie movie = movieRepository.findById(movieID).orElse(null);
//        User user = userRepository.findById(userID).orElse(null);

//        Favorite.FavoriteId favoriteId = new Favorite.FavoriteId();
//        favoriteId.setMovieID(movieID);
//        favoriteId.setUserID(userID);
//
//        Favorite favorite = new Favorite();
//        favorite.setId(favoriteId);
        if (existingMovie.isPresent()) {
            int res = movieRepository.deleteFavorite(movieID, userID);
//            favoriteRepository.save(favorite);
            return res;
        } else {
//            favoriteRepository.deleteById(favoriteId);
            int res = movieRepository.insertFavorite(movieID, userID);
            return res;
        }
    }
}
