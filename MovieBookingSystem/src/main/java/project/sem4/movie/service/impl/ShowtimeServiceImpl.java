package project.sem4.movie.service.impl;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Showtimes;
import project.sem4.movie.repository.ShowtimeRepository;
import project.sem4.movie.service.ShowtimeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public List<Showtimes> getAllShowTimes() {
        return showtimeRepository.findAll();
    }

    @Override
    public List<String> getAllStartDateShowtimes() {
        LocalDate date= LocalDate.now();
        return showtimeRepository.getAllStartDateShowtimes()
                .stream().filter(localDate -> localDate.compareTo(date)>=0)
                .map(localDate -> localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .collect(Collectors.toList());
    }


    @Override
    public Showtimes getShowTimeById(int showtime_id) {
        Optional<Showtimes> optionalShowtime = showtimeRepository.findById(showtime_id);
        return optionalShowtime.orElse(null);
    }

    @Override
    public Showtimes pushShowTime(Showtimes newShowtime) {
        return showtimeRepository.save(newShowtime);
    }

    @Override
    public Showtimes updateShowTime(Showtimes updateShowtime, int showtime_id) {
        Optional<Showtimes> optionalShowtime = showtimeRepository.findById(showtime_id);
        if (optionalShowtime.isPresent()) {
            Showtimes existingShowtime = optionalShowtime.get();
            existingShowtime.setStartTime(updateShowtime.getStartTime());
            existingShowtime.setEndTime(updateShowtime.getEndTime());
            // Update other attributes as needed

            return showtimeRepository.save(existingShowtime);
        }
        return null; // Showtime with given ID not found
    }

    @Override
    public void deleteShowTimeById(int showtime_id) {
        showtimeRepository.deleteById(showtime_id);
    }

    @Override
    public List<Showtimes> getAllShowtimes(LocalDate startDate) {
        return showtimeRepository.findAll().stream().filter(s -> s.getStartTime().after(Date.from(startDate.atStartOfDay().toInstant(ZoneOffset.UTC))))
                .collect(Collectors.toList());
    }


}
