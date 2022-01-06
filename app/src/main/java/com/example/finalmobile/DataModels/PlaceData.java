package com.example.finalmobile.DataModels;

public class PlaceData {
    public String name;
    public String type;
    public double lat;
    public double lng;
    public float rating;
    public Integer imageUrl;
    public String address;
    public String description;
    // Popular mentions? - smth like under renovation, statues, turtles

    public PlaceData(String name, String type, double lat, double lng, float rating,
                     Integer imageUrl, String address, String description) {
        this.name = name;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
        this.description = description;
    }
}
