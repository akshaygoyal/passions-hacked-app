package de.stetro.booking.application.data;

public enum DeckType {

    TRAVEL_OPTIONS(1, "travel_options", "Travel"),
    THEMES(2, "themes", "Themes"),
    ACTIVITIES(3, "broad_activities", "Activities"),
    LOCATIONS(4, "locations", "Locations");

    private final String deckType;
    private final int index;
    private final String label;

    DeckType(int index, String deckType, String label) {
        this.index = index;
        this.deckType = deckType;
        this.label = label;
    }

    public static DeckType getDeckType(int ind) {
        for (DeckType type : values()) {
            if (type.index == ind) {
                return type;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return deckType;
    }
}
