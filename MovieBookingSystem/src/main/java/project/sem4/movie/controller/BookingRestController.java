/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package project.sem4.movie.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import project.sem4.movie.entities.Bookings;
import project.sem4.movie.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/bookings")
@RestController
public class BookingRestController {
    private final BookingService bookingService;

    @Autowired
    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Bookings> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable("bookingId") int bookingId) {
        Bookings booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Bookings createBooking(@RequestBody Bookings newBooking) {
        return bookingService.pushBooking(newBooking);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Bookings> updateBooking(
            @RequestBody Bookings updatedBooking,
            @PathVariable("bookingId") int bookingId) {
        Bookings booking = bookingService.updateBooking(updatedBooking, bookingId);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable("bookingId") int bookingId) {
        bookingService.deleteBookingById(bookingId);
    }
}
