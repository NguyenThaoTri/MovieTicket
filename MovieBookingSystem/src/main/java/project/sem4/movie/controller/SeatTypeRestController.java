package project.sem4.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.SeatTypes;
import project.sem4.movie.service.SeatTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/seatTypes")
public class SeatTypeRestController {

    private final SeatTypeService seatTypeService;

    @Autowired
    public SeatTypeRestController(SeatTypeService seatTypeService) {
        this.seatTypeService = seatTypeService;
    }

    @GetMapping
    public ResponseEntity<List<SeatTypes>> getAllSeatTypes() {
        List<SeatTypes> seatTypes = seatTypeService.getAllSeatTypes();
        return new ResponseEntity<>(seatTypes, HttpStatus.OK);
    }

    @GetMapping("/{seatTypeId}")
    public ResponseEntity<SeatTypes> getSeatTypeById(@PathVariable int seatTypeId) {
        SeatTypes seatType = seatTypeService.getSeatTypeById(seatTypeId);
        if (seatType != null) {
            return new ResponseEntity<>(seatType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SeatTypes> createSeatType(@RequestBody SeatTypes newSeatType) {
        SeatTypes createdSeatType = seatTypeService.pushSeatType(newSeatType);
        return new ResponseEntity<>(createdSeatType, HttpStatus.CREATED);
    }

    @PutMapping("/{seatTypeId}")
    public ResponseEntity<SeatTypes> updateSeatType(
            @RequestBody SeatTypes updateSeatType,
            @PathVariable int seatTypeId
    ) {
        SeatTypes updatedSeatType = seatTypeService.updateSeatType(updateSeatType, seatTypeId);
        if (updatedSeatType != null) {
            return new ResponseEntity<>(updatedSeatType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{seatTypeId}")
    public ResponseEntity<Void> deleteSeatTypeById(@PathVariable int seatTypeId) {
        seatTypeService.deleteSeatTypeById(seatTypeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
