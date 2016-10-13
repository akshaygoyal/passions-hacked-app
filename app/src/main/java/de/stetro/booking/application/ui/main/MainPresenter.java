package de.stetro.booking.application.ui.main;


import javax.inject.Inject;

import de.stetro.booking.application.service.HelloWorldService;
import de.stetro.booking.application.config.di.util.Presenter;

public class MainPresenter implements Presenter<MainView> {

    private final HelloWorldService helloWorldService;
    private MainView view;

    public MainPresenter(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
        helloWorldService.doSomething();
    }
}
