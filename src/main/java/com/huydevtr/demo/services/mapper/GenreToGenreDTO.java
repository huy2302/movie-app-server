package com.huydevtr.demo.services.mapper;

import com.huydevtr.demo.models.DTOentities.GenreDTO;
import com.huydevtr.demo.models.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class GenreToGenreDTO implements Function<Genre, GenreDTO> {

    @Override
    public GenreDTO apply(Genre genre) {
        return new GenreDTO(
                genre.getGenreID(),
                genre.getGenre()
        );
    }
}
