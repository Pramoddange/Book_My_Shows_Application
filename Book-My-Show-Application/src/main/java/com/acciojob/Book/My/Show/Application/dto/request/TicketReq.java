package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class TicketReq {
private String movieName;

private LocalDate showDate;

private LocalTime showTime;

private List<String >seatNo;

private int theaterId;

private String modNo;

}
