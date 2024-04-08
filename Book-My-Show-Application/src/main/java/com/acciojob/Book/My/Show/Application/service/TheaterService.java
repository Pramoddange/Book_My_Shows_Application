package com.acciojob.Book.My.Show.Application.service;

import com.acciojob.Book.My.Show.Application.Enum.SeatType;
import com.acciojob.Book.My.Show.Application.dto.request.AddTheaterEntity;
import com.acciojob.Book.My.Show.Application.dto.request.AddTheaterSeatReq;
import com.acciojob.Book.My.Show.Application.entity.Theater;
import com.acciojob.Book.My.Show.Application.entity.TheaterSeat;
import com.acciojob.Book.My.Show.Application.repository.TheaterRepo;
import com.acciojob.Book.My.Show.Application.repository.TheaterSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepo theaterRepo;
    @Autowired
    TheaterSeatRepo theaterSeatRepo;
    public String addTheater(AddTheaterEntity addTheaterEntity){
        Theater theater=Theater.builder().name(addTheaterEntity.getName())
                        .address(addTheaterEntity.getAddress())
                                .noOfScreen(addTheaterEntity.getNoOfScreen()) .build();
      //  theater.setAddress(addTheaterEntity.getAddress());
        //theater.setName(addTheaterEntity.getName());
        //theater.setNoOfScreen(addTheaterEntity.getNoOfScreen());
        theater=theaterRepo.save(theater);
        return "The theater is with theaterId"+theater.getTheaterId();
    }
    public String addTheaterSeat(AddTheaterSeatReq reqBody){
        int noOfClassicSeat=reqBody.getNoOfClassicSeat();
        int noOfPremiumSeat=reqBody.getNoOfPremiumSeat();
        int theaterId=reqBody.getTheaterId();
        Theater theater=theaterRepo.findById(theaterId).get();
        int classicSeatCounter=1;
        int rowNo=1;
        char ch='A';
        List<TheaterSeat>theaterSeatsList=new ArrayList<>();
        while(classicSeatCounter<=noOfClassicSeat){
            String seatNo=rowNo+""+ch;
            TheaterSeat theaterSeat=TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeat);
            ch++;
            if(classicSeatCounter%5==0){
               rowNo= rowNo+1;
                ch='A';
            }
            classicSeatCounter++;
        }
        int premiumSeatCounter=1;
        if(classicSeatCounter%5!=1) {
            rowNo = rowNo + 1;
        }
         ch='A';

        while(premiumSeatCounter<=noOfPremiumSeat){
            String seatNo=rowNo+""+ch;
            TheaterSeat theaterSeat=TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeat);
            ch++;
            if(premiumSeatCounter%5==0){
                rowNo= rowNo+1;
                ch='A';
            }
            premiumSeatCounter++;
        }
        theater.setTheaterSeatList(theaterSeatsList);
        theaterRepo.save(theater);
        // theaterSeatRepo.saveAll(theaterSeatsList);
        //automatical save because of cascading handled bidirectional mapping
        return "Theatre seat have been generated";
    }
}
