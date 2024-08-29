/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Users;

/**
 *
 * @author NTT
 */
public interface UserService {
    List<Users> getAllUsers();
    
    Users getUserByEmail(String email);
    
    Users getUserById(int user_id);
    
    Users pushUser(Users newShowtime);
    
    Users updateUser(Users updateShowtime, int user_id);
    
    void deleteUserById(int user_id);
}
