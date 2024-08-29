/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.movie.client.controller;

import fpt.aptech.movie.client.constant.Api;
import fpt.aptech.movie.client.dto.MovieDTO;
import fpt.aptech.movie.client.entities.Movies;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NTT
 */
@Controller
public class MovieController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_GET_MOVIES = Api.Url + "/movies";
    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/admin/movies")
    public String index(Model model) {
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(API_GET_MOVIES, MovieDTO[].class);
        MovieDTO[] movies = response.getBody();
        Stream.of(Objects.requireNonNull(movies)).forEach(movie -> {
            movie.setPhoto("/images/".concat(movie.getPhoto()));
        });
        model.addAttribute("movies", movies);
        return "admin/manage-movie";
    }

    @GetMapping("/admin/movies/update/{movieId}")
    public String update(@PathVariable("movieId") int id, Model model) {
        ResponseEntity<MovieDTO> response = restTemplate.getForEntity(API_GET_MOVIES + "/" + id, MovieDTO.class);
        MovieDTO movie = response.getBody();
        model.addAttribute("movie", movie);
        return "admin/manage-movie";
    }

    @GetMapping("admin/movies/add")
    public String addMovie(HttpSession session, Model model) {
        model.addAttribute("movie", new MovieDTO());
        return "admin/add-movie";
    }
    
    @PostMapping(path = "admin/movies/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upMovie(@ModelAttribute("movie") MovieDTO movie) throws ExceptionInInitializerError, IOException {
        String fileName = movie.getPhoto();
        FileCopyUtils.copy(movie.getPhoto().getBytes(), new File(this.fileUpload, fileName)); 
        Movies newMovie = new Movies(movie.getTitle(), movie.getDescription(), movie.getDuration(),
                movie.getGenre(), movie.getReleaseDate(), movie.getIsPresent(), "images" + fileName);
        restTemplate.postForEntity(API_GET_MOVIES + "/", newMovie, Movies.class);
        return "redirect:/admin/movies";
    }

}
