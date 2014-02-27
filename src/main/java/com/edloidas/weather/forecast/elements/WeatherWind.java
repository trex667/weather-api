package com.edloidas.weather.forecast.elements;

/**
 * POJO
 * Weather wind data.
 */
public class WeatherWind {

    private float speed;
    private int deg;

    public WeatherWind() {
        this.speed = 0;
        this.deg = 0;
    }

    public WeatherWind(float speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
