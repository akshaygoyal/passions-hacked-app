package de.stetro.booking.application.config.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.stetro.booking.application.service.HelloWorldService;
import de.stetro.booking.application.ui.main.MainPresenter;
import de.stetro.booking.application.ui.question.QuestionPresenter;

@Module
@Singleton
public class PresenterModule {

    @Provides
    static MainPresenter provideMainPresenter(HelloWorldService helloWorldService) {
        return new MainPresenter(helloWorldService);
    }

    @Provides
    static QuestionPresenter provideQuestionPresenter() {
        return new QuestionPresenter();
    }

    @Provides
    static HelloWorldService provideHelloWorldService() {
        return new HelloWorldService();
    }

}
