package de.stetro.booking.application.ui.hotel;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.config.di.Presenter;
import de.stetro.booking.application.data.Hotel;
import de.stetro.booking.application.data.Hotels;

import de.stetro.booking.application.service.Api;
import de.stetro.booking.application.ui.question.QuestionPresenter;
import de.stetro.booking.application.ui.hoteldetails.HotelDetailsActivity;
import de.stetro.booking.application.ui.hoteldetails.HotelDetailsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelPresenter implements Presenter<HotelView> {

    @Inject
    public QuestionPresenter questionPresenter;

    @Inject
    public Api api;

    private HotelView view;
    private List<Hotel> hotels = new ArrayList<>();
    private Integer selectedHotel = null;
    private boolean isLoading = false;

    public HotelPresenter(Context context) {
        MainApplication.getApplicationComponent(context).inject(this);
    }

    private void loadHotels() {
        isLoading = true;
        renderLoading();
        api.getHotels(questionPresenter.getState()).enqueue(new Callback<Hotels>() {
            @Override
            public void onResponse(Call<Hotels> call, Response<Hotels> response) {
                hotels.clear();
                hotels.addAll(response.body().getHotels());
                isLoading = false;
                render();
                renderLoading();
            }

            @Override
            public void onFailure(Call<Hotels> call, Throwable t) {
                Toast.makeText(view.getContext(), "Could not load Hotels", Toast.LENGTH_LONG).show();
                isLoading = false;
                renderLoading();
            }
        });
    }

    private void renderLoading() {
        this.view.setLoading(isLoading);
    }

    @Override
    public void setView(HotelView view) {
        this.view = view;
        loadHotels();

    }

    public Hotel getSelectedHotel(){
        return hotels.get(selectedHotel);
    }

    private void render() {
        view.setState(hotels, selectedHotel);
    }

    void selectHotel(int position) {
        this.selectedHotel = position;
    }
}
