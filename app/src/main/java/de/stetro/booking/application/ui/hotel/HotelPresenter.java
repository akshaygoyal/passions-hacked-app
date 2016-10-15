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
        hotels.add(new Hotel("Casa 400", "Amsterdam", "http://www.archello.com/sites/default/files/imagecache/header_detail_large/story/media/Casa%2001.jpg", "description", "8,4", 3));
        hotels.add(new Hotel("Casa 400", "Amsterdam", "http://www.archello.com/sites/default/files/imagecache/header_detail_large/story/media/Casa%2001.jpg", "description", "8,4", 3));
        hotels.add(new Hotel("Casa 400", "Amsterdam", "http://www.archello.com/sites/default/files/imagecache/header_detail_large/story/media/Casa%2001.jpg", "description", "8,4", 3));
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
