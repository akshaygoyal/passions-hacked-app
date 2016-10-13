package de.stetro.booking.application.ui.main;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.R;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    @Inject
    public MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getApplicationComponent(this).inject(this);
        setContentView(R.layout.activity_main);
        presenter.setView(this);
        findViewById(R.id.button).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Calendar now = Calendar.getInstance();

    }
}
