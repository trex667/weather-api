package com.edloidas.weather;

import com.edloidas.weather.forecast.WeatherForecast;

/**
 * Weather fetcher interface.
 * Fetches data and generates forecast.
 */
public interface WeatherFetcher {

    /**
     * Method fetches json data.
     *
     * @return json as {@code String}.
     */
    public String fetchJson();

    /**
     * Method fetches json data and creates forecast.
     *
     * @return weather forecast.
     */
    public WeatherForecast fetch();
}
