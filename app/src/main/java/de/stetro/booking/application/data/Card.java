package de.stetro.booking.application.data;

public class Card {

    private int id;
    private String desc;
    private String imageUrl;
    private String term;

    public Card() {
    }

    public Card(int id, String desc, String imageUrl, String term) {
        this.id = id;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
