package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Genre;
import com.huydevtr.demo.models.entities.Movie;
import com.huydevtr.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
