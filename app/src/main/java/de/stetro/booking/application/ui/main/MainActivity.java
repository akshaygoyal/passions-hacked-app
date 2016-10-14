package de.stetro.booking.application.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.R;

public class MainActivity extends AppCompatActivity implements MainView, DatePickerDialog.OnDateSetListener {

    @Inject
    public MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getApplicationComponent(this).inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.setView(this);
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
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {

    }
}
