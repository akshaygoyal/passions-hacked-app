package de.stetro.booking.application.ui.main;


import java.util.Date;

public interface MainView {
    void setState(Date startDate, Date endDate, Integer budget);
}
