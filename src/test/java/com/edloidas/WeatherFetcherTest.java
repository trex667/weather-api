package com.edloidas;

import com.edloidas.weather.CurrentWeatherFetcher;
import com.edloidas.weather.WeatherFetcher;
import com.edloidas.weather.forecast.elements.Coordinates;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WeatherFetcherTest extends Assert {
    private static Logger LOGGER = Logger.getLogger(WeatherFetcherTest.class);

    @Test
    public void testWrongCity()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher("qwerty");
            assertTrue(fetcher.fetchJson().equalsIgnoreCase("{\"message\":\"Error: Not found city\",\"cod\":\"404\"}"));
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
        assertTrue( true );
    }

    @Test
    public void testWrongCoordinates()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher(new Coordinates(99999, -99999));
            assertTrue(fetcher.fetchJson().equalsIgnoreCase("{\"message\":\"Error: Not found city\",\"cod\":\"404\"}"));
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
        assertTrue( true );
    }
}
