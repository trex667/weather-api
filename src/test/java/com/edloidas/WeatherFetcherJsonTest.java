package com.edloidas;

import com.edloidas.weather.CurrentWeatherFetcher;
import com.edloidas.weather.WeatherFetcher;
import com.edloidas.weather.forecast.elements.Coordinates;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WeatherFetcherJsonTest extends Assert {

    private static Logger LOGGER = Logger.getLogger(WeatherFetcherJsonTest.class);

    @BeforeClass
    public static void beforeWeatherFetcherTest() {
        LOGGER.info("Start Fetcher's JSON test");
    }

    @Test
    public void testWrongCity()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher("qwerty");

            assertEquals(fetcher.fetchJson(), "{\"message\":\"Error: Not found city\",\"cod\":\"404\"}");
            LOGGER.info("testWrongCity() passed.");
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    @Test
    public void testWrongCoordinates()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher(new Coordinates(99999, -99999));

            assertEquals(fetcher.fetchJson(), "{\"message\":\"Error: Not found city\",\"cod\":\"404\"}");
            LOGGER.info("testWrongCoordinates() passed.");
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    @AfterClass
    public static void afterWeatherFetcherTest() {
        LOGGER.info("End Fetcher's JSON test");
    }
}
