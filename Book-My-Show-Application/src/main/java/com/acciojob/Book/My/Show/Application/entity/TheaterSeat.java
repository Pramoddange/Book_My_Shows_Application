package com.acciojob.Book.My.Show.Application.entity;

import com.acciojob.Book.My.Show.Application.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theater_seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterSetId;
    private String seatNo;
    @Enumerated(value =EnumType.STRING)
    private SeatType seatType;
    @JoinColumn
    @ManyToOne
    Theater theater;

}
