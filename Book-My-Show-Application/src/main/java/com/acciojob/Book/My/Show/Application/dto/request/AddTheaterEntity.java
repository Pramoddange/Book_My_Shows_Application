package com.acciojob.Book.My.Show.Application.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddTheaterEntity {
    private String name;
    private String address;
    private int noOfScreen;

}
