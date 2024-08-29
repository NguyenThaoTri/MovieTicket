/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 *
 * @author NTT
 */
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userId;
    @NotBlank(message = "Email can not be null!!!" )
    @Email(message = "Invalid email!!!")
    private String email;
    @NotBlank(message = "Username can not be null!!!" )
    private String username;
    @NotBlank(message = "Password can not be null!!!")
    @Size(min=6,message = "Password has at least 6 digit!!!")
    private String password;
    private String role;
}
