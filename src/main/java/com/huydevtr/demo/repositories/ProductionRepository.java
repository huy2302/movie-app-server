package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Integer> {
}
