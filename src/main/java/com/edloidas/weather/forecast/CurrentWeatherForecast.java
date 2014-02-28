package com.edloidas.weather.forecast;

import com.edloidas.weather.forecast.elements.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO
 * Weather forecast for the single moment.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherForecast implements WeatherForecast {

    private Coordinates coord;
    private WeatherSystem sys;
    private List<WeatherData> weather;
    private String base;
    private WeatherMain main;
    private WeatherWind wind;
    private WeatherClouds clouds;
    private WeatherSnow snow;
    private long dt;
    private long id;
    private String name;
    private int cod;

    public CurrentWeatherForecast() {
        this.coord = new Coordinates(0, 0);
        this.sys = new WeatherSystem();
        this.weather = new ArrayList<WeatherData>();
        this.base = "";
        this.main = new WeatherMain();
        this.wind = new WeatherWind();
        this.clouds = new WeatherClouds();
        this.dt = 0;
        this.id = 0;
        this.name = "";
        this.cod = 0;
    }

    public CurrentWeatherForecast(Coordinates coord,
                                  WeatherSystem sys, List<WeatherData> weather,
                                  String base, WeatherMain main, WeatherWind wind,
                                  WeatherClouds clouds, long dt, long id, String name, int cod) {
        this.coord = coord;
        this.sys = sys;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public WeatherSystem getSys() {
        return sys;
    }

    public void setSys(WeatherSystem sys) {
        this.sys = sys;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public WeatherWind getWind() {
        return wind;
    }

    public void setWind(WeatherWind wind) {
        this.wind = wind;
    }

    public WeatherClouds getClouds() {
        return clouds;
    }

    public void setClouds(WeatherClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherSnow getSnow() {
        return snow;
    }

    public void setSnow(WeatherSnow snow) {
        this.snow = snow;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(sys.getCountry())
          .append(" (").append(coord.getLon()).append(",").append(coord.getLat()).append(")")
          .append(": t=").append(main.getTemp()).append("°C, ").append(main.getPressure()).append("atm");

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"cod\":").append(cod).append("}");

        return sb.toString();
    }
}
