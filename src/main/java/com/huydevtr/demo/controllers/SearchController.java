package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.DTOentities.MovieDTO;
import com.huydevtr.demo.models.DTOentities.PersonDTO;
import com.huydevtr.demo.services.MovieService;
import com.huydevtr.demo.services.PersonService;
import com.huydevtr.demo.services.mapper.MovieToMovieDTO;
import com.huydevtr.demo.services.mapper.PersonToPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "search")
public class SearchController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonToPersonDTO personToPersonDTO;
    @Autowired
    MovieService movieService;
    @Autowired
    MovieToMovieDTO movieToMovieDTO;

    @GetMapping("")
    public ResponseEntity<?> searchByName (
            @RequestParam(value = "q") String q
    ) {
        List<PersonDTO> actors = personService.findActorsByActorName(q)
                .stream()
                .map(personToPersonDTO::ActorToPersonDTO)
                .collect(Collectors.toList());

        List<MovieDTO> movies = movieService.findMoviesByMovieTitle(q)
                .stream()
                .map(movieToMovieDTO::apply)
                .collect(Collectors.toList());

        int total = actors.size() + movies.size();

        Map<String, Object> apiRes = new HashMap<>();
        apiRes.put("total", total);
        apiRes.put("actors", actors);
        apiRes.put("movies", movies);

        return new ResponseEntity<>(
                apiRes,
                HttpStatus.OK
        );
    }
}
