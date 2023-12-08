package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
//    Actor findById(int actorID);
    @Query(value = "SELECT * FROM actor " +
            " JOIN movie_actor ON movie_actor.actorID = actor.actorID" +
            " WHERE movie_actor.movieID = :movieID", nativeQuery = true)
    List<Actor> findActorByNamedParamsNative(@Param("movieID") Integer movieID);
}
