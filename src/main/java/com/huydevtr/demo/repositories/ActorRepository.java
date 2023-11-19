package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findById(int actorID);
}
