package de.stetro.booking.application.ui.main;


import java.util.Date;

import de.stetro.booking.application.config.di.Presenter;

public class MainPresenter implements Presenter<MainView> {

    private MainView view;
    private Integer budget = 0;
    private Date startDate = new Date();
    private Date endDate = new Date();

    public MainPresenter() {
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
        render();
    }

    private void render() {
        view.setState(startDate, endDate, budget);
    }

    public void setBudgetProgressValue(int progress) {
        budget = (int) Math.pow(progress, 2) + 100;
        render();
    }

    public void setDates(Date startDate, Date endDate){
        this.startDate = startDate;
        this.endDate = endDate;
        render();
    }

}
