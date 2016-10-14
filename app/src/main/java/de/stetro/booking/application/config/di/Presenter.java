package de.stetro.booking.application.config.di;


public interface Presenter<T> {
    void setView(T view);
}
