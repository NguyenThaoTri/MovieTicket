package project.sem4.movie.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Movies;
import project.sem4.movie.entities.Showtimes;
import project.sem4.movie.repository.MovieRepository;
import project.sem4.movie.repository.ShowtimeRepository;
import project.sem4.movie.service.MovieService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ShowtimeRepository showtimeRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movies getMovieById(int movieId) {
        Optional<Movies> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.orElse(null);
    }

    @Override
    public Movies pushMovie(Movies newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movies updateMovie(Movies updatedMovie, int movieId) {
        Optional<Movies> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movies existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setDuration(updatedMovie.getDuration());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setReleaseDate(updatedMovie.getReleaseDate());
            existingMovie.setIsPresent(updatedMovie.getIsPresent());
            // Update other attributes as needed

            return movieRepository.save(existingMovie);
        }
        return null; // Movie with given ID not found
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public List<Showtimes> getAllShowtimeByMovieId(int movieId) {
        Movies movie = getMovieById(movieId);
        return new ArrayList<>(movie.getShowtimesCollection());
    }

    @Override
    public List<Showtimes> getAllShowtimeByMovieIdAndDate(int movieId, LocalDate startTime) {
        Movies movie = getMovieById(movieId);
        return movie.getShowtimesCollection().stream().filter(s -> s.getStartTime().equals(startTime)).collect(Collectors.toList());
    }

    @Override
    public List<Movies> getMovieIsPresent(boolean isPresent) {
        if (isPresent == true) {
            return movieRepository.findAll().stream().filter(s -> s.getIsPresent() == true).collect(Collectors.toList());
        } else {
            return movieRepository.findAll().stream().filter(s -> s.getIsPresent() == false).collect(Collectors.toList());
        }
    }
    
    
}
