package com.example.finalmobile.DataModels;

public class HotelData {
    public String name;
    public Integer price; // USD
    public double lat;
    public double lng;
    public float rating;
    public Integer imageUrl;
    public String address;
    public String description;
    public Boolean hasPool;
    public Boolean hasWifi;
    public Boolean hasFitness;

    public HotelData(String name, Integer price, double lat, double lng, float rating,
                     Integer imageUrl, String address, String description, Boolean hasPool,
                     Boolean hasWifi, Boolean hasFitness) {
        this.name = name;
        this.price = price;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
        this.description = description;
        this.hasPool = hasPool;
        this.hasWifi = hasWifi;
        this.hasFitness = hasFitness;
    }
}
