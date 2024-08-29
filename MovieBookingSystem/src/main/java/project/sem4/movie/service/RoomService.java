/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Room;

/**
 *
 * @author NTT
 */
public interface RoomService {
    List<Room> getAllRooms();
    
    Room getRoomById(int room_id);
    
    Room pushRoom(Room newRoom);
    
    Room updateRoom(Room updateRoom, int room_id);
    
    void deleteRoomById(int room_id);
}
