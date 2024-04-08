package com.acciojob.Book.My.Show.Application.entity;

import com.acciojob.Book.My.Show.Application.Enum.Genre;
import com.acciojob.Book.My.Show.Application.Enum.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @Column(unique = true)
    private String movieName;
    private double rating;
    @Enumerated(value = EnumType.STRING)
    private Genre type;
    private LocalDate releaseDate;
    private double duration;
    @Enumerated(value = EnumType.STRING)
    private Language language;
}
