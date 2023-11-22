package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
