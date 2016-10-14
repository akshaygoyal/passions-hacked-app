package de.stetro.booking.application.config.di;

import dagger.Component;
import de.stetro.booking.application.service.HelloWorldService;
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

    MainPresenter getMainPresenter();

    QuestionPresenter getQuestionPresenter();

    HelloWorldService getHelloWorldService();
}
