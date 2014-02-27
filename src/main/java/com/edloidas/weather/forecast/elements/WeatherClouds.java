package com.edloidas.weather.forecast.elements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * POJO
 * Weather clouds data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherClouds {

    private int all;

    public WeatherClouds() {
        this.all = 0;
    }

    public WeatherClouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
