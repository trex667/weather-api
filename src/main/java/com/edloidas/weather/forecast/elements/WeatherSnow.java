package com.edloidas.weather.forecast.elements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * POJO
 * Weather snow.
 * FOR FUTURE USE ONLY.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherSnow {

    private float threeH;

    public WeatherSnow() {
        this.threeH = 0;
    }

    public WeatherSnow(float threeH) {
        this.threeH = threeH;
    }

    public float get3h() {
        return threeH;
    }

    public void set3h(float threeH) {
        this.threeH = threeH;
    }
}
