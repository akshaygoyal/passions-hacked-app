package de.stetro.booking.application.ui.hotel;

import java.util.ArrayList;
import java.util.List;

import de.stetro.booking.application.config.di.Presenter;
import de.stetro.booking.application.data.Hotel;

public class HotelPresenter implements Presenter<HotelView> {
    private HotelView view;
    private List<Hotel> hotels = new ArrayList<>();
    private Integer selectedHotel = null;

    public HotelPresenter() {
        hotels.add(new Hotel("Hotel #1"));
    }

    @Override
    public void setView(HotelView view) {
        this.view = view;
        render();
    }

    private void render() {
        view.setState(hotels, selectedHotel);
    }

    public void selectHotel(int position) {
        this.selectedHotel = position;
    }
}
