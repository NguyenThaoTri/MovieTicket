/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Bookings;

/**
 *
 * @author NTT
 */
public interface BookingService {
    List<Bookings> getAllBookings();
    
    Bookings getBookingById(int booking_id);
    
    Bookings pushBooking(Bookings newBooking);
    
    Bookings updateBooking(Bookings updateBooking, int booking_id);
    
    void deleteBookingById(int booking_id);
}
