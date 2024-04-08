package com.acciojob.Book.My.Show.Application.repository;

import com.acciojob.Book.My.Show.Application.entity.Movie;
import com.acciojob.Book.My.Show.Application.entity.Show;
import com.acciojob.Book.My.Show.Application.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepo extends JpaRepository<Show,Integer> {
    public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate,
                                                                LocalTime showTime,
                                                                Movie movie,
                                                                Theater theater);
}