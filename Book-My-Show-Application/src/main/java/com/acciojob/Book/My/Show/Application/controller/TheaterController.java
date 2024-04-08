package com.acciojob.Book.My.Show.Application.controller;

import com.acciojob.Book.My.Show.Application.dto.request.AddTheaterEntity;
import com.acciojob.Book.My.Show.Application.dto.request.AddTheaterSeatReq;
import com.acciojob.Book.My.Show.Application.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @RequestMapping("/add")
    public String addTheater(@RequestBody AddTheaterEntity theater){
        return theaterService.addTheater(theater);
    }
    @RequestMapping("/addSeat")
    public String addTheaterSeat(@RequestBody AddTheaterSeatReq addTheaterSeatReq){
        return theaterService.addTheaterSeat(addTheaterSeatReq);
    }
}
