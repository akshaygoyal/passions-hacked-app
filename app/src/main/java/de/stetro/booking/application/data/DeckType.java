package de.stetro.booking.application.data;

public enum DeckType {

    TRAVEL_OPTIONS(1, "travel_options"),
    THEMES(2, "themes"),
    BROAD_ACTIVITIES(3, "broad_activities"),
    LOCATIONS(4, "locations"),
    GENERAL_ACTIVITIES(5, "general_activities");

    private final String deckType;
    private final int index;

    DeckType(int index, String deckType) {
        this.index = index;
        this.deckType = deckType;
    }

    public static DeckType getDeckType(int ind) {
        for (DeckType type : values()) {
            if (type.index == ind) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return deckType;
    }
}
