package com.acciojob.Book.My.Show.Application.controller;

import com.acciojob.Book.My.Show.Application.dto.request.TicketReq;
import com.acciojob.Book.My.Show.Application.entity.Ticket;
import com.acciojob.Book.My.Show.Application.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/create")
    public ResponseEntity createTicket(@RequestBody TicketReq ticketReq){

        try {

            Ticket ticket = ticketService.createTicket(ticketReq);
            return new ResponseEntity(ticket, HttpStatus.OK);

        }catch (Exception e) {
            String errMsg = "Error while booking you tickets : "+e.getMessage();
            return new ResponseEntity(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
