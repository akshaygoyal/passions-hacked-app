package de.stetro.booking.application.ui.hotel;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.config.di.Presenter;
import de.stetro.booking.application.data.Hotel;

public class HotelPresenter implements Presenter<HotelView> {
    private HotelView view;
    private List<Hotel> hotels = new ArrayList<>();
    private Integer selectedHotel = null;

    public HotelPresenter(Context context) {
        MainApplication.getApplicationComponent(context).inject(this);

        hotels.add(new Hotel(123, 8.4, 3, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), "https://media-cdn.tripadvisor.com/media/photo-s/08/37/ec/d7/exterior.jpg", "Casa 400", "Amsterdam"));
    }

    @Override
    public void setView(HotelView view) {
        this.view = view;
        render();
    }

    private void render() {
        view.setState(hotels, selectedHotel);
    }

    void selectHotel(int position) {
        this.selectedHotel = position;
    }
}
