/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package project.sem4.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.sem4.movie.entities.SeatTypes;

/**
 *
 * @author NTT
 */
public interface SeatTypeRepository extends JpaRepository<SeatTypes, Integer> {
    
}