package de.stetro.booking.application.config.di;

import dagger.Component;
import de.stetro.booking.application.service.HelloWorldService;
import de.stetro.booking.application.ui.hotel.HotelActivity;
import de.stetro.booking.application.ui.hotel.HotelPresenter;
import de.stetro.booking.application.ui.main.MainActivity;
import de.stetro.booking.application.ui.main.MainPresenter;
import de.stetro.booking.application.ui.main.MainView;
import de.stetro.booking.application.ui.question.QuestionActivity;
import de.stetro.booking.application.ui.question.QuestionPresenter;

@Component(modules = PresenterModule.class)
public interface ApplicationComponent {

    MainActivity inject(MainActivity mainView);

    MainPresenter inject(MainPresenter mainPresenter);

    QuestionPresenter inject(QuestionPresenter mainPresenter);

    QuestionActivity inject(QuestionActivity mainPresenter);

    HotelActivity inject(HotelActivity hotelActivity);

    HotelPresenter inject(HotelPresenter hotelPresenter);

    MainPresenter getMainPresenter();

    QuestionPresenter getQuestionPresenter();

    HelloWorldService getHelloWorldService();
}
