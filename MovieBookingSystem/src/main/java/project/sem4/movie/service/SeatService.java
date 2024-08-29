/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Seats;

/**
 *
 * @author NTT
 */
public interface SeatService {
    List<Seats> getAllSeats();
    
    Seats getSeatsById(int seat_id);
    
    Seats pushSeat(Seats newSeat);
    
    Seats updateSeat(Seats updateSeat, int seat_id);
    
    void deleteSeatById(int seat_id);
}
