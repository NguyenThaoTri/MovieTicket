/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.time.LocalDate;
import java.util.List;
import project.sem4.movie.entities.Movies;
import project.sem4.movie.entities.Showtimes;

/**
 *
 * @author NTT
 */
public interface MovieService {
    List<Movies> getAllMovies();

    Movies getMovieById(int movie_id);

    Movies pushMovie(Movies newMovie);

    Movies updateMovie(Movies updatedMovie, int movie_id);

    void deleteMovie(int movie_id);

    List<Showtimes> getAllShowtimeByMovieId(int movie_id);

    List<Showtimes> getAllShowtimeByMovieIdAndDate(int movie_id, LocalDate startTime);
    
    List<Movies> getMovieIsPresent(boolean isPresent);
    
}
