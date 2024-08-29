package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.SeatTypes;
import project.sem4.movie.repository.SeatTypeRepository;
import project.sem4.movie.service.SeatTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    private final SeatTypeRepository seatTypeRepository;

    @Autowired
    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository) {
        this.seatTypeRepository = seatTypeRepository;
    }

    @Override
    public List<SeatTypes> getAllSeatTypes() {
        return seatTypeRepository.findAll();
    }

    @Override
    public SeatTypes getSeatTypeById(int seatTypeId) {
        Optional<SeatTypes> optionalSeatType = seatTypeRepository.findById(seatTypeId);
        return optionalSeatType.orElse(null);
    }

    @Override
    public SeatTypes pushSeatType(SeatTypes newSeatType) {
        return seatTypeRepository.save(newSeatType);
    }

    @Override
    public SeatTypes updateSeatType(SeatTypes updateSeatType, int seatTypeId) {
        Optional<SeatTypes> optionalSeatType = seatTypeRepository.findById(seatTypeId);
        if (optionalSeatType.isPresent()) {
            SeatTypes existingSeatType = optionalSeatType.get();
            existingSeatType.setTypeName(updateSeatType.getTypeName());
            existingSeatType.setPrice(updateSeatType.getPrice());
            // Update other attributes as needed

            return seatTypeRepository.save(existingSeatType);
        }
        return null; // Seat type with given ID not found
    }

    @Override
    public void deleteSeatTypeById(int seatTypeId) {
        seatTypeRepository.deleteById(seatTypeId);
    }
}
