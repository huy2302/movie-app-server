package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
//    @Query(value = "SELECT * FROM actor WHERE actor.actorID = :actorID", nativeQuery = true)
//    Actor findByActorID(int actorID);

    @Query(value = "SELECT * FROM actor " +
            " JOIN movie_actor ON movie_actor.actorID = actor.actorID" +
            " WHERE movie_actor.movieID = :movieID", nativeQuery = true)
    List<Actor> findActorByNamedParamsNative(@Param("movieID") Integer movieID);

    @Query(value = "SELECT * FROM actor WHERE actor.actorName LIKE %:actorName%", nativeQuery = true)
    List<Actor> findActorByActorNameContainingIgnoreCase(String actorName);
}
