package de.stetro.booking.application.ui.question;


import java.util.ArrayList;

import de.stetro.booking.application.config.di.Presenter;
import de.stetro.booking.application.data.Question;

public class QuestionPresenter implements Presenter<QuestionView> {
    private QuestionView view;

    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<String> layers = new ArrayList<>();
    private Integer activeLayer = 0;
    private Integer activeCard = 0;

    public QuestionPresenter() {

        questions.add(new Question("By Car", "http://www.plugincars.com/sites/default/files/leaf-road-620.jpg"));
        questions.add(new Question("By Train", "http://www.interrail.eu/sites/interrail.eu/files/styles/asset_image_universal_size_460x307/public/tgv_high-spped_train_france.jpg?itok=5QsjCqOM"));
        questions.add(new Question("By Plane", "http://az616578.vo.msecnd.net/files/2016/03/07/635929352622573191-1360068289_plane-in-blue-sky-136397593033103901-150416160347.jpg"));

        layers.add("Transport");
        layers.add("Location");
        layers.add("Hotel");
        layers.add("Activity");

    }

    @Override
    public void setView(QuestionView view) {
        this.view = view;
        render();
    }

    private void render() {
        view.setState(questions, layers, activeLayer, activeCard);
    }

    public void swipeRight(int position) {
        activeCard = position+1;
        if (activeLayer < layers.size() - 1) {
            activeLayer++;
        }
        render();
    }

    public void swipeLeft(int position) {
        activeCard = position+1;
        if (activeLayer > 0) {
            activeLayer--;
        }
        render();
    }
}
