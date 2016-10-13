package de.stetro.booking.application;

import android.app.Application;
import android.content.Context;

import de.stetro.booking.application.config.di.ApplicationComponent;
import de.stetro.booking.application.config.di.DaggerApplicationComponent;
import de.stetro.booking.application.config.di.PresenterModule;


public class MainApplication extends Application {
    private ApplicationComponent component;

    public static void clearApplicationComponent(Context context) {
        MainApplication mainApplication = (MainApplication) context.getApplicationContext();
        mainApplication.component = null;
    }

    public static ApplicationComponent getApplicationComponent(Context context) {
        MainApplication mainApplication = (MainApplication) context.getApplicationContext();
        if (mainApplication.component == null) {
            mainApplication.component = DaggerApplicationComponent.builder()
                    .presenterModule(getPresenterModule())
                    .build();
        }
        return mainApplication.component;
    }

    public static PresenterModule getPresenterModule() {
        return new PresenterModule();
    }
}
