package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.Data;

@Data
public class AddReqShowSeat {
    private int showId;
    private int priceOfClassicSeat;
    private  int priceOfPremiumSeat;
}
