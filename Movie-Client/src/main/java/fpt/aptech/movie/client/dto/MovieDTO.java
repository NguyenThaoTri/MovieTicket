/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.dto;

import lombok.*;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NTT
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieDTO {
    private int movieId;
    private String title;
    private String description;
    private Integer duration;
    private String genre;
    private Date releaseDate;
    private Boolean isPresent;
    private String photo;
   
}
