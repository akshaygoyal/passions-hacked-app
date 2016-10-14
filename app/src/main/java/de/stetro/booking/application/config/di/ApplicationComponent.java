package de.stetro.booking.application.config.di;

import dagger.Component;
import de.stetro.booking.application.service.HelloWorldService;
import de.stetro.booking.application.ui.main.MainActivity;
import de.stetro.booking.application.ui.main.MainPresenter;
import de.stetro.booking.application.ui.main.MainView;

@Component(modules = PresenterModule.class)
public interface ApplicationComponent {

    MainView inject(MainView mainView);

    MainPresenter inject(MainPresenter mainPresenter);

    MainPresenter getMainPresenter();

    HelloWorldService getHelloWorldService();
}
