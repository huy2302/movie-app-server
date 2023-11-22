package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
