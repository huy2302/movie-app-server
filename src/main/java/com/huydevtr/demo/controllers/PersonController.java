package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.DTOentities.ActorSlim;
import com.huydevtr.demo.models.DTOentities.PersonDTO;
import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.services.PersonService;
import com.huydevtr.demo.services.mapper.PersonToPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonToPersonDTO personToPersonDTO;
    @GetMapping("/actor/{id}")
    public ResponseEntity<List<PersonDTO>> actorList(
            @PathVariable(value = "id") int id
    ){
        List<Actor> actors = personService.actorList(id);
        return new ResponseEntity<>(actors.stream()
                .map(personToPersonDTO::ActorToPersonDTO)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

//    @GetMapping("/actor/{id}")
//    public ResponseEntity<List<PersonDTO>> getListActorByMovieId(
//            @PathVariable(value = "id") int id
//    ) {
//        List<Actor> actors = personService.findActorByMovieID(id);
//        List<PersonDTO> actorDTOs = actors.stream()
//                .map(personToPersonDTO::ActorToPersonDTO)
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(actorDTOs, HttpStatus.OK);
//    }
}
