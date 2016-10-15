package de.stetro.booking.application.ui.question;

import java.util.List;

import de.stetro.booking.application.data.Question;

interface QuestionView {
    void setLayer(List<String> layers, Integer currentLayer);

    void setQuestions(List<Question> questions, Integer activeCard);

    void setLoading(boolean isLoading);
}
