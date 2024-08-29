/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package project.sem4.movie.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Movies;
import project.sem4.movie.entities.Showtimes;
import project.sem4.movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    private final MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movies> getMovieById(@PathVariable("movieId") int movieId) {
        Movies movie = movieService.getMovieById(movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody Movies newMovie) {
        return movieService.pushMovie(newMovie);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movies> updateMovie(
            @RequestBody Movies updatedMovie,
            @PathVariable("movieId") int movieId) {
        Movies movie = movieService.updateMovie(updatedMovie, movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(movieId);
    }

    @GetMapping("/{movieId}/showtimes")
    public List<Showtimes> getAllShowtimesByMovieId(@PathVariable("movieId") int movieId) {
        return movieService.getAllShowtimeByMovieId(movieId);
    }

    @GetMapping("/{movieId}/showtimes/{startTime}")
    public List<Showtimes> getAllShowtimesByMovieIdAndDate(
            @PathVariable("movieId") int movieId,
            @PathVariable("startTime") LocalDate startTime) {
        return movieService.getAllShowtimeByMovieIdAndDate(movieId, startTime);
    }
    
    @GetMapping("/showing")
    public List<Movies> findAllShowingMovies(){
        return movieService.getMovieIsPresent(true);
    }
    @GetMapping("/coming")
    public List<Movies> findAllComingMovies(){
        return movieService.getMovieIsPresent(false);
    }
}
