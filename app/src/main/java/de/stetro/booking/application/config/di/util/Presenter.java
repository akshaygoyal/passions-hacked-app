package de.stetro.booking.application.config.di.util;


public interface Presenter<T> {
    void setView(T view);
}
