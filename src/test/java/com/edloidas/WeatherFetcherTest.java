package com.edloidas;

import com.edloidas.weather.CurrentWeatherFetcher;
import com.edloidas.weather.WeatherFetcher;
import com.edloidas.weather.forecast.WeatherForecast;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WeatherFetcherTest extends Assert {

    private static Logger LOGGER = Logger.getLogger(WeatherFetcherTest.class);

    @BeforeClass
    public static void beforeWeatherFetcherTest() {
        LOGGER.info("Start Fetcher's Forecast test");
    }

    @Test
    public void testForecastFormat()
    {
        try {
            String staticJson = "{\"coord\":{\"lon\":27.57,\"lat\":53.9},\"sys\":{\"message\":0.0298,\"country\":\"BY\",\"sunrise\":1393477287,\"sunset\":1393515796},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":3,\"pressure\":1023,\"humidity\":47,\"temp_min\":3,\"temp_max\":3},\"wind\":{\"speed\":3,\"deg\":110,\"var_beg\":80,\"var_end\":140},\"clouds\":{\"all\":0},\"dt\":1393500600,\"id\":625144,\"name\":\"Minsk\",\"cod\":200}";

            WeatherFetcher fetcher = new CurrentWeatherFetcher("Oslo");
            WeatherForecast forecast = fetcher.fetch();

            assertEquals(forecast.format(), "Oslo, NO (10.75,59.91): t=3.0°C, 1013atm");
            LOGGER.info("testForecastFormat() passed.");
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    @Test
    public void testWrongCity()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher("qwerrty");
            WeatherForecast forecast = fetcher.fetch();

            assertNull(forecast);
            LOGGER.info("testWrongCity() passed.");
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    @AfterClass
    public static void afterWeatherFetcherTest() {
        LOGGER.info("End Fetcher's Forecast test");
    }
}
