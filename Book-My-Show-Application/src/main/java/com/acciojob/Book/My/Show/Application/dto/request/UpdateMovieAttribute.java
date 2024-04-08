package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateMovieAttribute {
    private int movieId;
    private double ratting;
    private double duration;
}
