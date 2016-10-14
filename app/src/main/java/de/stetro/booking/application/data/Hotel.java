package de.stetro.booking.application.data;

public class Hotel {
    private String name;
    private String imageUrl;
    private String description;
    private String rating;
    private Integer stars;

    public Hotel(String name, String imageUrl, String description, String rating, Integer stars) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.rating = rating;
        this.stars = stars;
    }

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
