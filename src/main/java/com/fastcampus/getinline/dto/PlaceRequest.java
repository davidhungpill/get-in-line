package com.fastcampus.getinline.dto;

import com.fastcampus.getinline.constants.PlaceType;

public record PlaceRequest(
    PlaceType placeType,
    String address,
    String phoneNumber,
    Integer capacity,
    String name,
    String memo
){
    public static PlaceRequest of(
            PlaceType placeType,
            String address,
            String phoneNumber,
            Integer capacity,
            String name,
            String memo
    ){
        return new PlaceRequest(placeType, address, phoneNumber, capacity, name, memo);
    }
}
