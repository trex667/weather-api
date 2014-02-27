package com.edloidas.weather;

import com.edloidas.weather.forecast.CurrentWeatherForecast;
import com.edloidas.weather.forecast.elements.Coordinates;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

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
        CurrentWeatherForecast forecast = null;
        String json = fetchJson();

        if (!json.isEmpty() && !json.contains("\"cod\":\"404\"")) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                forecast = mapper.readValue(json, CurrentWeatherForecast.class);
            } catch (Exception ex) {
                LOGGER.error(ex);
            }
        }

        return forecast;
    }
}
