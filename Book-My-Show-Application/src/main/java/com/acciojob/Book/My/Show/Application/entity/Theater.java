package com.acciojob.Book.My.Show.Application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;
    private String name;
    private String address;
    private int noOfScreen;
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeat>theaterSeatList=new ArrayList<>();

}
