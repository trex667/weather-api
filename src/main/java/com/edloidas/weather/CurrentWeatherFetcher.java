package com.edloidas.weather;

import com.edloidas.weather.forecast.AbstractWeatherFetcher;
import com.edloidas.weather.forecast.CurrentWeatherForecast;
import com.edloidas.weather.forecast.WeatherForecast;
import com.edloidas.weather.forecast.elements.Coordinates;
import org.apache.log4j.Logger;

/**
 * Created by mtaukachou.
 */
public class CurrentWeatherFetcher extends AbstractWeatherFetcher {

    private static Logger LOGGER = Logger.getLogger(CurrentWeatherFetcher.class);

    public CurrentWeatherFetcher(String city) {
        super(city);
    }

    public CurrentWeatherFetcher(Coordinates coord) {
        super(coord);
    }

    /**
     * Method fetches json data and creates forecast.
     *
     * @return weather forecast for the current moment.
     */
    public CurrentWeatherForecast fetch() {
        try {
            CurrentWeatherForecast forecast = new CurrentWeatherForecast();

        } catch (Exception ex) {
            LOGGER.error(ex);
        }
        return null;
    }
}
