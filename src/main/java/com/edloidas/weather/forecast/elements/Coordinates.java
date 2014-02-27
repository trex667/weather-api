package com.edloidas.weather.forecast.elements;

/**
 * POJO. Geographical coordinates.
 */
public class Coordinates {

    // Longitude
    private float lon = 0;

    // Latitude
    private float lat = 0;

    public Coordinates(float lon, float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
