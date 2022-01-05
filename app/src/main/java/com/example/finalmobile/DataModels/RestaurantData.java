package com.example.finalmobile.DataModels;

public class RestaurantData {
    public String name;
    public String speciality; // like chinese food, soups, sushi
    public double lat;
    public double lng;
    public float rating;
    public Integer imageUrl;

    public RestaurantData(String name, String speciality, double lat, double lng, float rating, Integer imageUrl){
        this.name = name;
        this.speciality = speciality;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }
}
