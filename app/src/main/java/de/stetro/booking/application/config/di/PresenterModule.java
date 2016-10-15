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
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class PresenterModule {

    private static MainPresenter mainPresenter;
    private static QuestionPresenter questionPresenter;
    private static HotelPresenter hotelPresenter;
    private Context context;

    public PresenterModule(Context context) {
        this.context = context;
    }

    @Provides
    static MainPresenter provideMainPresenter(Context context) {
        if (mainPresenter == null) {
            mainPresenter = new MainPresenter(context);
        }
        return mainPresenter;
    }

    @Provides
    static QuestionPresenter provideQuestionPresenter(Context context) {
        if (questionPresenter == null) {
            questionPresenter = new QuestionPresenter(context);
        }
        return questionPresenter;
    }

    @Provides
    static HotelPresenter provideHotelPresenter(Context context) {
        if (hotelPresenter == null) {
            hotelPresenter = new HotelPresenter(context);
        }
        return hotelPresenter;
    }

    @Provides
    static Retrofit provideRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        return new Retrofit.Builder()
                .baseUrl("https://passions-hacked.herokuapp.com/")
                .client(client)
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
