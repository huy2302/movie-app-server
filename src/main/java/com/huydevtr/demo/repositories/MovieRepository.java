package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.movieID = :movieID")
    Optional<Movie> findByMovieId(@Param("movieID") int movieID);

    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    Optional<Movie> findByTitle(@Param("title") String title);

    @Query(value = "SELECT * FROM movie WHERE movie.title LIKE %:movieTitle%", nativeQuery = true)
    List<Movie> findMovieByMovieTitle(String movieTitle);

    @Query(value = "SELECT * FROM movie " +
            " JOIN favorite ON favorite.movieID = movie.movieID" +
            " WHERE favorite.userID = :userID", nativeQuery = true)
    List<Movie> findMovieOnFavoriteByUserID(@Param("userID") int userID);

    @Query(value = "SELECT * FROM movie" +
            " INNER JOIN favorite ON movie.movieID = favorite.movieID" +
            " WHERE favorite.movieID = :movieID and favorite.userID = :userID", nativeQuery = true)
    Optional<Movie> checkEmptyFavorite (int movieID, int userID);
    @Modifying
    @Query(value = "INSERT INTO favorite VALUES (:movieID, :userID)", nativeQuery = true)
    Integer insertFavorite (int movieID, int userID);

    @Modifying
    @Query(value = "DELETE FROM favorite WHERE (`movieID` = :movieID) and (`userID` = :userID)", nativeQuery = true)
    Integer deleteFavorite (int movieID, int userID);
}
