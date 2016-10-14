package de.stetro.booking.application.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.R;
import de.stetro.booking.application.ui.question.QuestionActivity;

public class MainActivity extends AppCompatActivity implements MainView, DatePickerDialog.OnDateSetListener {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy", Locale.UK);

    @Inject
    public MainPresenter presenter;

    @BindView(R.id.main_seek_bar)
    public SeekBar seekBar;

    @BindView(R.id.main_period)
    public TextView periodTextView;

    @BindView(R.id.main_budget)
    public TextView budgetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getApplicationComponent(this).inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.setView(this);
        setTitle("");
        seekBar.setOnSeekBarChangeListener(new SeekbarAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                presenter.setBudgetProgressValue(progress);
            }
        });
    }

    @OnClick(R.id.date_range_button)
    public void onDateRangeButtonClicked() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        Date startDate = calendar.getTime();
        calendar.set(yearEnd, monthOfYearEnd, dayOfMonthEnd);
        Date endDate = calendar.getTime();
        presenter.setDates(startDate, endDate);
    }

    @OnClick(R.id.main_next_button)
    public void nextStepsClicked() {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    @Override
    public void setState(Date startDate, Date endDate, Integer budget) {
        periodTextView.setText(SIMPLE_DATE_FORMAT.format(startDate) + " - " + SIMPLE_DATE_FORMAT.format(endDate));
        budgetTextView.setText(budget + " €");
    }
}
