package de.stetro.booking.application.ui.hotel;

import java.util.List;

import de.stetro.booking.application.data.Hotel;

public interface HotelView {
    void setState(List<Hotel> hotels);
}
