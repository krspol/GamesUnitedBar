package com.fabian.gamesunitedbar.model;

/**
 * Created by Fabian Polkosnik on 26.06.2017.
 */

public class MenuItem {

    private String name;
    private String imageUrl;
    private String description;


    public MenuItem(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public MenuItem(String name, String imageUrl, String description) {
        this(name, imageUrl);
        this.description = description;
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

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
