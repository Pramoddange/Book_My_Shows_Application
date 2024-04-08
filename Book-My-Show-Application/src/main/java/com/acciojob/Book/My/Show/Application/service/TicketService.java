package com.acciojob.Book.My.Show.Application.service;

import com.acciojob.Book.My.Show.Application.repository.Exception.SeatUnavailableException;
import com.acciojob.Book.My.Show.Application.dto.request.TicketReq;
import com.acciojob.Book.My.Show.Application.entity.*;
import com.acciojob.Book.My.Show.Application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    TheaterRepo theaterRepo;
    @Autowired
    ShowRepo showRepo;
    @Autowired
    ShowSeatRepo showSeatRepo;
    @Autowired
    UserRepo userRepo;
    public Ticket createTicket(TicketReq ticketReq)throws Exception{
        //find ShowSeat
        Movie movie=movieRepo.findMovieName(ticketReq.getMovieName());
        Theater theater=theaterRepo.findById(ticketReq.getTheaterId()).get();
        Show show=showRepo.findShowByShowDateAndShowTimeAndMovieAndTheater(ticketReq.getShowDate(),ticketReq.getShowTime(),movie,theater);
                List<ShowSeat> showSeats=showSeatRepo.findShowSeatByShow(show);
        int totalAmount = 0;
        Boolean areAllSeatsAvailable =true;

        for(String seatNo:ticketReq.getSeatNo()) {
            for(ShowSeat showSeat:showSeats) {
                if(showSeat.getSeatNo().equals(seatNo))
                {
                    if(showSeat.isAvailable()==false){
                        areAllSeatsAvailable = false;
                        break;
                    }
                    totalAmount = totalAmount+showSeat.getPrice();
                }
            }
        }

        if(areAllSeatsAvailable==false){
            throw new SeatUnavailableException("The requested Seats are unavailable");
        }


        //2. Make the seats booked:(Only if seats are available : otherwise throw exception)

        for(String seatNo:ticketReq.getSeatNo()) {
            for(ShowSeat showSeat:showSeats) {
                if(showSeat.getSeatNo().equals(seatNo))
                {
                    showSeat.setAvailable(false);
                }
            }
        }

        User user = userRepo.findUserByMobNo(ticketReq.getModNo());

        //3. Save the ticketEntity

        Ticket ticket = Ticket.builder().user(user)
                .showName(ticketReq.getMovieName())
                .showDate(ticketReq.getShowDate())
                .theaterNameAndAddress(theater.getName()+" "+theater.getAddress())
                .showTime(ticketReq.getShowTime())
                .totalAmountPaid(totalAmount)
                .build();

        ticket = ticketRepo.save(ticket);

        //4. Generate and return back the actual ticket response

        return ticket;
    }
}
