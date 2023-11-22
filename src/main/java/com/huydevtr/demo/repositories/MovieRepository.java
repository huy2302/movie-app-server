package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
