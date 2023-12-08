package com.huydevtr.demo.services.mapper;

import com.huydevtr.demo.models.DTOentities.PersonDTO;
import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.Director;
import com.huydevtr.demo.models.entities.Writer;
import org.springframework.stereotype.Service;

@Service
public class PersonToPersonDTO{
    public PersonDTO ActorToPersonDTO(Actor actor) {
        return new PersonDTO(
                actor.getActorID(),
                actor.getActorName(),
                actor.getAge(),
                actor.getCountry(),
                actor.getGender(),
                actor.getAvt(),
                actor.getDescription()
        );
    }
    public PersonDTO DirectorToPersonDTO(Director director) {
        return new PersonDTO(
                director.getDirectorID(),
                director.getDirectorName(),
                director.getAge(),
                director.getCountry(),
                director.getGender(),
                director.getAvt(),
                director.getDescription()
        );
    }
    public PersonDTO WriterToPersonDTO(Writer writer) {
        return new PersonDTO(
                writer.getWriterID(),
                writer.getWriterName(),
                writer.getAge(),
                writer.getCountry(),
                writer.getGender(),
                writer.getAvt(),
                writer.getDescription()
        );
    }
}
