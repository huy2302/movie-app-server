package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
