package com.edloidas.weather;

import com.edloidas.weather.forecast.WeatherForecast;
import com.edloidas.weather.forecast.elements.Coordinates;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Abstract class, that represents fetcher object.
 * Retrieves json data and parses it.
 */
public abstract class AbstractWeatherFetcher implements WeatherFetcher {

    private static final Logger LOGGER = Logger.getLogger(AbstractWeatherFetcher.class);

    private StringBuilder url = null;

    protected static final String urlOrigin = "http://api.openweathermap.org/data/2.5/weather?";
    protected static final String urlConfig = "&units=metric";

    public AbstractWeatherFetcher(String city) {
        this.url = new StringBuilder();
        this.url.append(urlOrigin).append("q=").append(city).append(urlConfig);
    }

    public AbstractWeatherFetcher(Coordinates coord) {
        this.url = new StringBuilder();
        this.url.append(urlOrigin)
                .append("lat=").append(coord.getLat())
                .append("&lon=").append(coord.getLon()).append(urlConfig);
    }

    private void setLocation(String city) {
        this.url = new StringBuilder();
        this.url.append(urlOrigin).append("q=").append(city).append(urlConfig);
    }

    private void setLocation(Coordinates coord) {
        this.url = new StringBuilder();
        this.url.append(urlOrigin)
                .append("lat=").append(coord.getLat())
                .append("&lon=").append(coord.getLon()).append(urlConfig);
    }

    /**
     * Method fetches json data.
     *
     * @return json as {@code String}.
     */
    public String fetchJson() {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            URL weather = new URL(url.toString());
            URLConnection conn = weather.openConnection();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
        } catch (IOException ioEx) {
            LOGGER.error(ioEx);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    /**
     * Method fetches json data and creates forecast.
     *
     * @return weather forecast for the current moment.
     */
    public abstract WeatherForecast fetch();
}
