package com.acciojob.Book.My.Show.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String ticketId;

    private  String showName;

    private LocalDate showDate;


    private LocalTime showTime;

    private String theaterNameAndAddress;

    private int totalAmountPaid;

    @ManyToOne
    @JoinColumn
    User user;

}
