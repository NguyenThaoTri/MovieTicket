/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.SeatTypes;

/**
 *
 * @author NTT
 */
public interface SeatTypeService {
    List<SeatTypes> getAllSeatTypes();
    
    SeatTypes getSeatTypeById(int seatType_id);
    
    SeatTypes pushSeatType(SeatTypes newSeatType);
    
    SeatTypes updateSeatType(SeatTypes updateSeatType, int seatType_id);
    
    void deleteSeatTypeById(int seatType_id);
}
