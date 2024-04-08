package com.acciojob.Book.My.Show.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private LocalDate showDate;

    private LocalTime showTime;

    @ManyToOne
    @JoinColumn
    Movie movie;

    @ManyToOne
    @JoinColumn
    Theater theater;
}
