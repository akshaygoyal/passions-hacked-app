package de.stetro.booking.application.service;


import de.stetro.booking.application.data.Deck;
import de.stetro.booking.application.data.Hotels;
import de.stetro.booking.application.data.State;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("/questions/")
    Call<Deck> getQuestions(@Body State state);

    @POST("/hotels")
    Call<Hotels> getHotels(@Body State state);
}
