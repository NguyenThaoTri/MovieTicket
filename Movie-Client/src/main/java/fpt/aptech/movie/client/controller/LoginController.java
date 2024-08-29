/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.controller;

import fpt.aptech.movie.client.constant.Api;
import fpt.aptech.movie.client.dto.MovieDTO;
import fpt.aptech.movie.client.dto.UserDTO;
import fpt.aptech.movie.client.entities.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {
    @Value("${upload.path}")
    private String fileUpload;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String API_GET_USERS = Api.Url + "/users";
    public static final String API_GET_SHOWING_MOVIES = Api.Url + "/movies/showing";
    public static final String API_GET_COMING_MOVIES = Api.Url + "/movies/coming";
    public static final String API_GET_AllSTARTDATES = Api.Url + "/all-schedule-dates";

    @GetMapping()
    public String index(Model model) {
        ResponseEntity<MovieDTO[]> responseShowingMovies = restTemplate.getForEntity(API_GET_SHOWING_MOVIES, MovieDTO[].class);
        MovieDTO[] showingMovies = responseShowingMovies.getBody();
        Stream.of(Objects.requireNonNull(showingMovies)).forEach(movie -> {
            movie.setPhoto("/images/".concat(movie.getPhoto()));
        });
        ResponseEntity<MovieDTO[]> responseComingMovies = restTemplate.getForEntity(API_GET_COMING_MOVIES, MovieDTO[].class);
        MovieDTO[] comingMovies = responseComingMovies.getBody();
        Stream.of(Objects.requireNonNull(comingMovies)).forEach(movie -> {
            movie.setPhoto("/images/".concat(movie.getPhoto()));
        });
        model.addAttribute("showingMovies", showingMovies);
        model.addAttribute("comingMovies", comingMovies);
        return "home";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        String getByEmailUrl = API_GET_USERS + "/byEmail/{email}";
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        ResponseEntity<Users> response = restTemplate.getForEntity(getByEmailUrl, Users.class, params);
        if (response.getStatusCode() == HttpStatus.OK) {
            Users loggedInUser = response.getBody();
            if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
                if ("Admin".equals(loggedInUser.getRole())) {
                    return "redirect:/admin/home";
                } else if ("NotAdmin".equals(loggedInUser.getRole())) {
                    model.addAttribute("user", loggedInUser);
                    return "redirect:/";
                }
            }
        }
        model.addAttribute("user", new Users());
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            try {
                user.setRole("NotAdmin");
                String registrationUrl = API_GET_USERS;
                ResponseEntity<Users> response = restTemplate.postForEntity(registrationUrl, user, Users.class);
                if (response.getStatusCode() == HttpStatus.CREATED) {
                    return "redirect:/login";
                }
            }catch (HttpClientErrorException ex){
                    model.addAttribute("registerError",ex.getResponseBodyAsString());
                    model.addAttribute("hasErrors", true);
                    model.addAttribute("user",user);
                return "register";
            }
            return "redirect:/";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(API_GET_USERS, UserDTO[].class);
        UserDTO[] users = response.getBody();
        model.addAttribute("users", users);
        return "forgot-password";
    }

    @GetMapping("/sign-out")
    public String signOut(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @GetMapping("/admin/home")
    public String homeAdmin(Model model) {
        return "admin/home-admin";
    }

    @GetMapping("/admin/users")
    public String listUser(Model model) {
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(API_GET_USERS, UserDTO[].class);
        UserDTO[] users = response.getBody();
        model.addAttribute("users", users);
        return "admin/manage-user";
    }

}
