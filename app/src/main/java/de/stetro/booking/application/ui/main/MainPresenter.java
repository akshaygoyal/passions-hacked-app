package de.stetro.booking.application.ui.main;


import android.content.Context;

import java.util.Date;

import javax.inject.Singleton;

import de.stetro.booking.application.MainApplication;
import de.stetro.booking.application.config.di.Presenter;

public class MainPresenter implements Presenter<MainView> {

    private MainView view;
    private Integer budget = 0;
    private Date startDate;
    private Date endDate;

    public MainPresenter(Context context) {
        MainApplication.getApplicationComponent(context).inject(this);
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
        render();
    }

    private void render() {
        view.setState(startDate, endDate, budget);
    }

    void setBudgetProgressValue(int progress) {
        budget = (int) Math.pow(progress, 2) + 100;
        render();
    }

    void setDates(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        render();
    }

    public Integer getBudget() {
        return budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
