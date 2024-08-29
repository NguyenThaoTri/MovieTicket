/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package project.sem4.movie.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.sem4.movie.entities.Showtimes;

/**
 *
 * @author NTT
 */
public interface ShowtimeRepository extends JpaRepository<Showtimes, Integer> {
    List<Showtimes> findByMovieId(int movieId);

    List<Showtimes> findByMovieIdAndStartTime(int movieId, LocalDate startTime);

    List<Showtimes> findByStartTime(LocalDate startDate);

    List<Showtimes> findByEndTime(LocalDate endDate);

    @Query("SELECT DISTINCT s.startTime FROM Showtimes s")
    List<LocalDate> getAllStartDateShowtimes();

}
