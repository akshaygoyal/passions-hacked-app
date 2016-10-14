package de.stetro.booking.application.ui.main;


import de.stetro.booking.application.service.HelloWorldService;
import de.stetro.booking.application.config.di.Presenter;

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
