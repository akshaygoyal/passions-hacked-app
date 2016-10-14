package de.stetro.booking.application.ui.question;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.anton46.stepsview.StepsView;
import com.daprlabs.cardstack.SwipeDeck;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.R;
import de.stetro.booking.application.data.Question;


public class QuestionActivity extends AppCompatActivity implements QuestionView, SwipeDeck.SwipeEventCallback {

    @Inject
    public QuestionPresenter presenter;

    @BindView(R.id.questions_swipe_deck)
    public SwipeDeck swipeDeck;

    @BindView(R.id.questions_step_view)
    public StepsView stepsView;

    private QuestionCardAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getApplicationComponent(this).inject(this);
        setContentView(R.layout.activity_question);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(R.string.questions);

        adapter = new QuestionCardAdapter(new ArrayList<Question>(), this);

        swipeDeck.setAdapter(adapter);
        swipeDeck.setEventCallback(this);

        stepsView.setLabels(new String[]{"Travel", "Location", "Hotel", "Activity"})
                .setBarColorIndicator(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .setProgressColorIndicator(ContextCompat.getColor(this, R.color.primary))
                .setCompletedPosition(0)
                .drawView();

        presenter.setView(this);

    }

    @Override
    public void cardSwipedLeft(int position) {
        Log.i(QuestionActivity.class.getSimpleName(), "swipe left");
        presenter.swipeLeft(position);
    }

    @Override
    public void cardSwipedRight(int position) {
        Log.i(QuestionActivity.class.getSimpleName(), "swipe right");
        presenter.swipeRight(position);
    }

    @Override
    public void cardsDepleted() {

    }

    @Override
    public void cardActionDown() {

    }

    @Override
    public void cardActionUp() {

    }

    @Override
    public void setState(List<Question> questions, List<String> layers, Integer currentLayer, Integer activeCard) {
        adapter.setQuestions(questions);
        swipeDeck.setSelection(activeCard);
        stepsView.setLabels(layers.toArray(new String[layers.size()]))
                .setCompletedPosition(currentLayer)
                .drawView();

    }

    @OnClick(R.id.questions_skip_fab)
    public void skipQuestions() {

    }
}
