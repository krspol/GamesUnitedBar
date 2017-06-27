package com.fabian.gamesunitedbar.model;

/**
 * Created by Fabian Polkosnik on 27.06.2017.
 */

public class Food {

    private String image;
    private String title;
    private String description;
    private double price;
    boolean avaiable;

    public Food(String image, String title, String description, double price, boolean avaiable) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.price = price;
        this.avaiable = avaiable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvaiable() {
        return avaiable;
    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }
}
