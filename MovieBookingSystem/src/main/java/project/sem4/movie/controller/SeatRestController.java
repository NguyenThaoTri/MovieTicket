package project.sem4.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Seats;
import project.sem4.movie.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatRestController {

    private final SeatService seatService;

    @Autowired
    public SeatRestController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<List<Seats>> getAllSeats() {
        List<Seats> seats = seatService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<Seats> getSeatById(@PathVariable int seatId) {
        Seats seat = seatService.getSeatsById(seatId);
        if (seat != null) {
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Seats> createSeat(@RequestBody Seats newSeat) {
        Seats createdSeat = seatService.pushSeat(newSeat);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @PutMapping("/{seatId}")
    public ResponseEntity<Seats> updateSeat(
            @RequestBody Seats updateSeat,
            @PathVariable int seatId
    ) {
        Seats updatedSeat = seatService.updateSeat(updateSeat, seatId);
        if (updatedSeat != null) {
            return new ResponseEntity<>(updatedSeat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{seatId}")
    public ResponseEntity<Void> deleteSeatById(@PathVariable int seatId) {
        seatService.deleteSeatById(seatId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
