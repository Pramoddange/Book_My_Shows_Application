package com.acciojob.Book.My.Show.Application.repository;

import com.acciojob.Book.My.Show.Application.entity.Show;
import com.acciojob.Book.My.Show.Application.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepo extends JpaRepository<ShowSeat,Integer> {
    public List<ShowSeat> findShowSeatByShow(Show show);
}
