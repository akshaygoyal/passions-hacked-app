package de.stetro.booking.application.ui.question;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.config.di.Presenter;
import de.stetro.booking.application.data.Card;
import de.stetro.booking.application.data.Deck;
import de.stetro.booking.application.data.DeckType;
import de.stetro.booking.application.data.State;
import de.stetro.booking.application.service.Api;
import de.stetro.booking.application.ui.hotel.HotelActivity;
import de.stetro.booking.application.ui.main.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter implements Presenter<QuestionActivity> {

    @Inject
    public Api api;

    @Inject
    public MainPresenter mainPresenter;

    private QuestionActivity view;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<String> layers = new ArrayList<>();
    private State state = new State();
    private Integer activeLayer = 0;
    private boolean isLoading = false;


    public QuestionPresenter(Context context) {
        MainApplication.getApplicationComponent(context).inject(this);

        state.setBudget(mainPresenter.getBudget());
        state.setStartDate(mainPresenter.getStartDate());
        state.setEndDate(mainPresenter.getEndDate());

        layers.add(0, DeckType.TRAVEL_OPTIONS.getLabel());
        layers.add(1, DeckType.THEMES.getLabel());
        layers.add(2, DeckType.ACTIVITIES.getLabel());
        layers.add(3, DeckType.LOCATIONS.getLabel());
    }

    @Override
    public void setView(QuestionActivity view) {
        this.view = view;
        loadQuestions();
        renderLayer();
    }

    private void loadQuestions() {
        if (activeLayer >= DeckType.values().length) {
            Intent intent = new Intent(view, HotelActivity.class);
            view.startActivity(intent);
        } else {
            state.setDeckType(DeckType.values()[activeLayer]);

            isLoading = true;
            renderLoading();

            api.getQuestions(state).enqueue(new Callback<Deck>() {
                @Override
                public void onResponse(Call<Deck> call, Response<Deck> response) {
                    cards.clear();
                    cards.addAll(response.body().getCards());
                    renderQuestions();
                    isLoading = false;
                    renderLoading();
                    updateLayer();
                    state.getInterests().clear();
                }

                @Override
                public void onFailure(Call<Deck> call, Throwable t) {
                    Toast.makeText(view, "Could not load Cards", Toast.LENGTH_LONG).show();
                    isLoading = false;
                    renderLoading();
                }
            });
        }
    }

    private void renderLoading() {
        view.setLoading(isLoading);
    }

    private void renderQuestions() {
        view.setQuestions(cards, 0);
    }

    private void renderLayer() {
        view.setLayer(layers);
        view.setActiveLayer(activeLayer);
    }


    private void updateLayer() {
        view.setActiveLayer(activeLayer);
    }

    void swipeRight(int position) {
        state.getInterests().add(cards.get(position).getTerm());
        if (position == cards.size() - 1) {
            activeLayer++;
            loadQuestions();
        }
    }

    void swipeLeft(int position) {
        if (position == cards.size() - 1) {
            activeLayer++;
            loadQuestions();
        }
    }

    public void reset() {
        this.activeLayer = 0;
        this.state.getInterests().clear();
    }

    public State getState() {
        return state;
    }
}
