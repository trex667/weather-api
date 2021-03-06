package com.edloidas.weather.forecast.elements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * POJO
 * Weather main data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain {

    private float temp;
    private int pressure;
    private int humidity;
    private float temp_min;
    private float temp_max;

    public WeatherMain() {
        this.temp = 0;
        this.pressure = 0;
        this.humidity = 0;
        this.temp_min = 0;
        this.temp_max = 0;
    }

    public WeatherMain(float temp,
                       int pressure, int humidity,
                       float temp_min, float temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}
