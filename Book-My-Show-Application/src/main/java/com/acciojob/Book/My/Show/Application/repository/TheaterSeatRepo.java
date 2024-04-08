package com.acciojob.Book.My.Show.Application.repository;

import com.acciojob.Book.My.Show.Application.entity.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepo extends JpaRepository<TheaterSeat,Integer> {

}
