package de.stetro.booking.application.ui.question;

import java.util.List;

import de.stetro.booking.application.data.Question;

public interface QuestionView {
    void setState(List<Question> questions, List<String> layers, Integer currentLayer, Integer activeCard);
}
