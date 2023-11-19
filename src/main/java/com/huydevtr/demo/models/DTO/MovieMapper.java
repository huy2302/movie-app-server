package com.huydevtr.demo.models.DTO;
import com.huydevtr.demo.models.DTOentities.*;
import com.huydevtr.demo.models.entities.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MovieMapper {
    Movie getMovieByMovieID(int MovieID);
    ActorSlim actorToActorSlim(Actor actor);
    DirectorSlim directorToDirectorSlim(Director director);
    WriterSlim writerToWriterSlim(Writer writer);
    MovieDTO movieToMovieDetails(Movie movie);
//    ArrayList<ActorSlim> getListActorByMovieID(int movieID);
    List<String> getListActorByMovieID(int movieID);
}
