package de.stetro.booking.application.data;

import java.util.List;

public class Hotels {

    private List<Hotel> hotels;


    public Hotels() {
    }

    public Hotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
