package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Seats;
import project.sem4.movie.repository.SeatRepository;
import project.sem4.movie.service.SeatService;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seats> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seats getSeatsById(int seatId) {
        Optional<Seats> optionalSeat = seatRepository.findById(seatId);
        return optionalSeat.orElse(null);
    }

    @Override
    public Seats pushSeat(Seats newSeat) {
        return seatRepository.save(newSeat);
    }

    @Override
    public Seats updateSeat(Seats updateSeat, int seatId) {
        Optional<Seats> optionalSeat = seatRepository.findById(seatId);
        if (optionalSeat.isPresent()) {
            Seats existingSeat = optionalSeat.get();
            existingSeat.setIsBooked(updateSeat.getIsBooked());
            // Update other attributes as needed

            return seatRepository.save(existingSeat);
        }
        return null; // Seat with given ID not found
    }

    @Override
    public void deleteSeatById(int seatId) {
        seatRepository.deleteById(seatId);
    }
}
