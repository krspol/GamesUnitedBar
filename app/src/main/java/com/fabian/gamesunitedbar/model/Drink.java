package com.fabian.gamesunitedbar.model;

/**
 * Created by Fabian Polkosnik on 28.06.2017.
 */

public class Drink {

    private String photo;
    private String name;
    private double volume;
    private double price;


    public Drink(String photo, String name, double volume, double price) {
        this.photo = photo;
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }
}
