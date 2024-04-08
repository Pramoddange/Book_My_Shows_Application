package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddTheaterSeatReq {
    private int theaterId;
    private int noOfClassicSeat;
    private int noOfPremiumSeat;
}
