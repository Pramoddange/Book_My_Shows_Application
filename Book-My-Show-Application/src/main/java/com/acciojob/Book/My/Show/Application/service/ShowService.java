package com.acciojob.Book.My.Show.Application.service;

import com.acciojob.Book.My.Show.Application.Enum.SeatType;
import com.acciojob.Book.My.Show.Application.dto.request.AddReqShowSeat;
import com.acciojob.Book.My.Show.Application.dto.request.AddShowReq;
import com.acciojob.Book.My.Show.Application.entity.*;
import com.acciojob.Book.My.Show.Application.repository.MovieRepo;
import com.acciojob.Book.My.Show.Application.repository.ShowRepo;
import com.acciojob.Book.My.Show.Application.repository.ShowSeatRepo;
import com.acciojob.Book.My.Show.Application.repository.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
@Autowired
    ShowRepo showRepo;
@Autowired
    MovieRepo movieRepo;
@Autowired
    TheaterRepo theaterRepo;
@Autowired
    ShowSeatRepo showSeatRepo;
public String addShow(AddShowReq showReq){
    Movie movie=movieRepo.findMovieName(showReq.getMovieName());

    Theater theater=theaterRepo.findById(showReq.getTheaterId()).get();

    Show show=Show.builder().showDate(showReq.getShowDate())
            .showTime(showReq.getShowTime())
            .theater(theater)
            .movie(movie)
            .build();
   show=showRepo.save(show);
    return "show add successfully by showId"+show.getShowId();
}
    public String addShoeSeat(AddReqShowSeat showSeatReq){
      int showId=showSeatReq.getShowId();
      Show show=showRepo.findById(showId).get();
      Theater theater=show.getTheater();
        List<TheaterSeat>theaterSeats=theater.getTheaterSeatList();
        List<ShowSeat>showSeats=new ArrayList<>();
        for(TheaterSeat theaterSeat:theaterSeats) {
            ShowSeat showSeat = ShowSeat.builder().seatType(theaterSeat.getSeatType())
                    .seatNo(theaterSeat.getSeatNo())
                    .isAvailable(Boolean.TRUE)
                    .show(show)
                    .build();
            if(theaterSeat.getSeatType()== SeatType.CLASSIC){
                showSeat.setPrice(showSeatReq.getPriceOfClassicSeat());
            }else{
                showSeat.setPrice(showSeatReq.getPriceOfPremiumSeat());
            }
            showSeats.add(showSeat);
        }
        showSeatRepo.saveAll(showSeats);
        return "All seat are updated by the show";
    }
}
