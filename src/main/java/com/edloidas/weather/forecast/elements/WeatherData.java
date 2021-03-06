package com.edloidas.weather.forecast.elements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * POJO
 * Weather metadata.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    private int id;
    private String main;
    private String description;
    private String icon;

    public WeatherData() {
        this.id = 0;
        this.main = "";
        this.description = "";
        this.icon = "";
    }

    public WeatherData(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
