/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.time.LocalDate;
import java.util.List;
import project.sem4.movie.entities.Showtimes;

/**
 *
 * @author NTT
 */
public interface ShowtimeService {
    List<Showtimes> getAllShowTimes();

    List<String> getAllStartDateShowtimes();
    
    Showtimes getShowTimeById(int showtime_id);
    
    Showtimes pushShowTime(Showtimes newShowtime);
    
    Showtimes updateShowTime(Showtimes updateShowtime, int showtime_id);
    
    void deleteShowTimeById(int showtime_id);
    
    List<Showtimes> getAllShowtimes(LocalDate startDate);

}
