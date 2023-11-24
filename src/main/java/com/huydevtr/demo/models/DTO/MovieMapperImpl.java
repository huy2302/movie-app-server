package com.huydevtr.demo.models.DTO;

import com.huydevtr.demo.models.DTOentities.*;
import com.huydevtr.demo.models.entities.*;
import com.huydevtr.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Service
public class MovieMapperImpl implements MovieMapper{
    MovieRepository movieRepository;
    GenreRepository genreRepository;
    ActorRepository actorRepository;
    DirectorRepository directorRepository;
    ProductionRepository productionRepository;
    WriterRepository writerRepository;
    MovieActorRepository movieActorRepository;
    @Autowired
    public MovieMapperImpl(
            MovieRepository movieRepository,
            GenreRepository genreRepository,
            ActorRepository actorRepository,
            DirectorRepository directorRepository,
            ProductionRepository productionRepository,
            WriterRepository writerRepository,
            MovieActorRepository movieActorRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.productionRepository = productionRepository;
        this.writerRepository = writerRepository;
        this.movieActorRepository = movieActorRepository;
    }


    @Override
    public Movie getMovieByMovieID(int MovieID) {
        return null;
    }
    // trả về diễn viên rút gọn với tên và ảnh
    @Override
    public ActorSlim actorToActorSlim(Actor actor) {
        return new ActorSlim(
                actor.getActorName(),
                actor.getAvt()
        );
    }
    // trả về đạo diễn rút gọn với tên và ảnh
    @Override
    public DirectorSlim directorToDirectorSlim(Director director) {
        return new DirectorSlim(
                director.getDirectorName(),
                director.getAvt()
        );
    }// trả về diễn viên rút gọn với tên và ảnh
    @Override
    public WriterSlim writerToWriterSlim(Writer writer) {
        return new WriterSlim(
                writer.getWriterName(),
                writer.getAvt()
        );
    }

    @Override
    public MovieDTO movieToMovieDetails(Movie movie) {
        if (movie == null) {
            return null;
        }
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieID(movie.getMovieID());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setYear(movie.getYear());
        movieDTO.setRated(movie.getRated());
        movieDTO.setReleased(movie.getReleased());
        movieDTO.setRuntime(movie.getRuntime());
//        movieDetails.setGenre(movie.getGenre());
        movieDTO.setPlot(movie.getDescription());
        movieDTO.setLanguage(movie.getLanguage());
        movieDTO.setCountry(movie.getCountry());
        movieDTO.setAwards(movie.getAwards());
        movieDTO.setPoster(movie.getPoster());
        // lấy danh sách diễn viên để thêm vào movieDetails
        List<String> actors = getListActorByMovieID(movie.getMovieID());
        movieDTO.setActors(actors);

        return movieDTO;
    }

//    @Override
//    public ArrayList<ActorSlim> getListActorByMovieID(int movieID) {
//        List<MovieActor> movieActors =  movieActorRepository.findAllByMovieMovieID(movieID);
//        ArrayList<Actor> actors = new ArrayList<>();
//        ArrayList<ActorSlim> actorSlims = new ArrayList<>();
//        movieActors.forEach(movieActor -> {
//            Actor actor = actorRepository.findById(movieActor.getActor().getActorID());
//            actors.add(actor);
//        });
//        actors.forEach(actor -> {
//            actorSlims.add(actorToActorSlim(actor));
//        });
//        return actorSlims;
//    }
    @Override
    public List<String> getListActorByMovieID(int movieID) {
        List<MovieActor> movieActors =  movieActorRepository.findAllByMovieMovieID(movieID);

        List<String> listActor = new ArrayList<>();
        movieActors.forEach(movieActor -> {
            Actor actor = actorRepository.findById(movieActor.getActor().getActorID());
            listActor.add(actor.getActorName());
        });

        return listActor;
    }
}
