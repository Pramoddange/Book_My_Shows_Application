package com.acciojob.Book.My.Show.Application.entity;

import com.acciojob.Book.My.Show.Application.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seat")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private int price;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn
    Show show;


}
