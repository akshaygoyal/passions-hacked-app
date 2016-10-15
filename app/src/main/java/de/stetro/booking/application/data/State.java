package de.stetro.booking.application.data;

import java.util.Date;
import java.util.List;

public class State {

    private Date startDate;
    private Date endDate;
    private double budget;
    private DeckType deckType;
    private List<String> interests;

    public State(Date startDate, Date endDate, double budget, DeckType deckType, List<String> interests) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.deckType = deckType;
        this.interests = interests;
    }

    public State() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public DeckType getDeckType() {
        return deckType;
    }

    public void setDeckType(DeckType deckType) {
        this.deckType = deckType;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
