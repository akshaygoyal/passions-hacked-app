package de.stetro.booking.application.ui.question;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

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
import de.stetro.booking.application.ui.hotel.HotelActivity;


public class QuestionActivity extends AppCompatActivity implements QuestionView {

    @Inject
    public QuestionPresenter presenter;

    @BindView(R.id.questions_swipe_deck)
    public SwipeDeck swipeDeck;

    @BindView(R.id.questions_step_view)
    public StepsView stepsView;

    @BindView(R.id.question_loader)
    public RelativeLayout loaderView;

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
        swipeDeck.setEventCallback(new SwipeDeckAdapter() {
            @Override
            public void cardSwipedLeft(int position) {
                presenter.swipeLeft(position);
            }

            @Override
            public void cardSwipedRight(int position) {
                presenter.swipeRight(position);
            }
        });

        stepsView.setLabels(new String[]{"Travel", "Location", "Hotel", "Activity"})
                .setBarColorIndicator(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .setProgressColorIndicator(ContextCompat.getColor(this, R.color.primary))
                .setCompletedPosition(0)
                .drawView();

        presenter.setView(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.questions_skip_fab)
    public void skipQuestions() {
        Intent intent = new Intent(this, HotelActivity.class);
        startActivity(intent);
    }

    @Override
    public void setLayer(List<String> layers, Integer currentLayer) {
        stepsView.setLabels(layers.toArray(new String[layers.size()]))
                .setCompletedPosition(currentLayer)
                .drawView();
    }

    @Override
    public void setQuestions(List<Question> questions, Integer activeCard) {
        adapter.setQuestions(questions);
        swipeDeck.setSelection(activeCard);
    }

    @Override
    public void setLoading(boolean isLoading) {
        loaderView.setVerticalGravity(isLoading ? View.VISIBLE : View.INVISIBLE);
    }
}
