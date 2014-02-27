package com.edloidas.weather.forecast.elements;

/**
 * POJO
 * Weather system data.
 */
public class WeatherSystem {

    private String message;
    private String country;
    private long sunrise;
    private long sunset;

    public WeatherSystem() {
        this.message = "";
        this.country = "";
        this.sunrise = 0;
        this.sunset = 0;
    }

    public WeatherSystem(String message, String country, long sunrise, long sunset) {
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
