/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.movie.client.controller;

import fpt.aptech.movie.client.constant.Api;
import fpt.aptech.movie.client.dto.UserDTO;
import fpt.aptech.movie.client.entities.Users;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author NTT
 */
@Controller
public class UserController {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_GET_USERS = Api.Url + "/users";
    
   @GetMapping("admin/users/add")
    public String addUser(HttpSession session, Model model) {
        model.addAttribute("user", new UserDTO());
        return "admin/add-user";
    } 
    
    @PostMapping("admin/users/add")
    public String registration(@Valid @ModelAttribute("user") Users user,
            BindingResult result,
            Model model) {
        String registrationUrl = API_GET_USERS;
        ResponseEntity<Users> response = restTemplate.postForEntity(registrationUrl, user, Users.class);
        if (result.hasErrors()) {
            model.addAttribute("hasErrors", true);
            model.addAttribute("user", user);
            return "admin/add-user";
        } else {
            if (response.getStatusCode() == HttpStatus.CREATED) {
                return "redirect:/";
            } else {
                model.addAttribute("user", user);
                return "admin/add-user";
            }
        }
    }
    
}
