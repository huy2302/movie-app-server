package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Integer> {
}
