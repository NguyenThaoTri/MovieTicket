package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Room;
import project.sem4.movie.repository.RoomRepository;
import project.sem4.movie.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(int room_id) {
        Optional<Room> optionalRoom = roomRepository.findById(room_id);
        return optionalRoom.orElse(null);
    }

    @Override
    public Room pushRoom(Room newRoom) {
        return roomRepository.save(newRoom);
    }

    @Override
    public Room updateRoom(Room updatedRoom, int room_id) {
        Optional<Room> optionalRoom = roomRepository.findById(room_id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setCapacity(updatedRoom.getCapacity());
            // Update other attributes as needed

            return roomRepository.save(existingRoom);
        }
        return null; // Room with given ID not found
    }

    @Override
    public void deleteRoomById(int room_id) {
        roomRepository.deleteById(room_id);
    }
}
