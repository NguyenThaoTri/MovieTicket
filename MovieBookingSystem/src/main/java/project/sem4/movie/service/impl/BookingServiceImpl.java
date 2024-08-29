/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package project.sem4.movie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Bookings;
import project.sem4.movie.repository.BookingRepository;
import project.sem4.movie.service.BookingService;

/**
 *
 * @author NTT
 */
@Service

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Bookings getBookingById(int booking_id) {
        return null;
    }

    @Override
    public Bookings pushBooking(Bookings newBooking) {
        return null;
    }

    @Override
    public Bookings updateBooking(Bookings updatedBooking, int booking_id) {
        return null;
    }

    @Override
    public void deleteBookingById(int booking_id) {

    }

}
