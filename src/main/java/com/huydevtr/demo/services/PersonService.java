package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Actor;
import com.huydevtr.demo.models.entities.Director;
import com.huydevtr.demo.models.entities.Writer;
import com.huydevtr.demo.repositories.ActorRepository;
import com.huydevtr.demo.repositories.DirectorRepository;
import com.huydevtr.demo.repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    WriterRepository writerRepository;
//    public List<Actor> findActorByMovieID (int movieID) {
//        return actorRepository.findAllByMovieMovieID(movieID);
//    }
    public List<Actor> actorList(int movieId) {
        return actorRepository.findActorByNamedParamsNative(movieId);
    }
}
