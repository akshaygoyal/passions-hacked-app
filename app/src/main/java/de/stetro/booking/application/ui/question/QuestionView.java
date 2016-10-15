package de.stetro.booking.application.ui.question;

import java.util.List;

import de.stetro.booking.application.data.Card;

interface QuestionView {
    void setLayer(List<String> layers);

    void setActiveLayer(Integer currentLayer);

    void setQuestions(List<Card> questions, Integer activeCard);

    void setLoading(boolean isLoading);
}
