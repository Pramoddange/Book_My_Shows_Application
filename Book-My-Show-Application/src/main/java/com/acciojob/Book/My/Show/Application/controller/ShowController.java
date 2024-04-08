package com.acciojob.Book.My.Show.Application.controller;

import com.acciojob.Book.My.Show.Application.dto.request.AddReqShowSeat;
import com.acciojob.Book.My.Show.Application.dto.request.AddShowReq;
import com.acciojob.Book.My.Show.Application.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;


    @RequestMapping("/addShow")
    public String addShow(@RequestBody AddShowReq ShowReq){
     return showService.addShow(ShowReq);
    }
    @RequestMapping("/addSeat")
    public String addShowSeat(@RequestBody AddReqShowSeat showSeat){
       return showService.addShoeSeat(showSeat);
    }
}
