package project.sem4.movie.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Showtimes;
import project.sem4.movie.service.ShowtimeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/showtimes")
public class ShowTimeRestController {

    private final ShowtimeService showtimeService;

    @Autowired
    public ShowTimeRestController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<List<Showtimes>> getAllShowTimes() {
        List<Showtimes> showTimes = showtimeService.getAllShowTimes();
        return new ResponseEntity<>(showTimes, HttpStatus.OK);
    }

    @GetMapping("/{showtimeId}")
    public ResponseEntity<Showtimes> getShowTimeById(@PathVariable int showtimeId) {
        Showtimes showTime = showtimeService.getShowTimeById(showtimeId);
        if (showTime != null) {
            return new ResponseEntity<>(showTime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Showtimes> createShowTime(@RequestBody Showtimes newShowTime) {
        Showtimes createdShowTime = showtimeService.pushShowTime(newShowTime);
        return new ResponseEntity<>(createdShowTime, HttpStatus.CREATED);
    }

    @PutMapping("/{showtimeId}")
    public ResponseEntity<Showtimes> updateShowTime(
            @RequestBody Showtimes updateShowTime,
            @PathVariable int showtimeId
    ) {
        Showtimes updatedShowTime = showtimeService.updateShowTime(updateShowTime, showtimeId);
        if (updatedShowTime != null) {
            return new ResponseEntity<>(updatedShowTime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<Void> deleteShowTimeById(@PathVariable int showtimeId) {
        showtimeService.deleteShowTimeById(showtimeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/start")
    public ResponseEntity<?> getAllShowtimes(@RequestParam(required = false) Map<String, String> dates) {
        List<Showtimes> screenings = null;
        if (!dates.isEmpty()) {
            LocalDate startDate = LocalDate.parse(dates.get("startDate"));
            screenings = showtimeService.getAllShowtimes(startDate);
        } else {
            screenings = showtimeService.getAllShowTimes();
        }
        return ResponseEntity.status(HttpStatus.OK).body(screenings);
    }

    @GetMapping("/all-schedule-dates")
    public List<String> getAllStartDate(){
        return  showtimeService.getAllStartDateShowtimes();
    }
}
