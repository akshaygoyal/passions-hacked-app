package de.stetro.booking.application.config.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.stetro.booking.application.service.Api;
import de.stetro.booking.application.ui.hotel.HotelPresenter;
import de.stetro.booking.application.ui.main.MainPresenter;
import de.stetro.booking.application.ui.question.QuestionPresenter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@Singleton
public class PresenterModule {

    private Context context;

    public PresenterModule(Context context) {
        this.context = context;
    }

    @Provides
    static MainPresenter provideMainPresenter(Context context) {
        return new MainPresenter(context);
    }

    @Provides
    static QuestionPresenter provideQuestionPresenter(Context context) {
        return new QuestionPresenter(context);
    }

    @Provides
    static HotelPresenter provideHotelPresenter(Context context) {
        return new HotelPresenter(context);
    }

    @Provides
    static Retrofit provideRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        return new Retrofit.Builder()
                .baseUrl("https://passions-hacked.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    static Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    Context provideContext() {
        return context;
    }

}
