package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowReq {
    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;

    private int theaterId;
}
