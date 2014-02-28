package com.edloidas.weather;

import com.edloidas.weather.forecast.WeatherForecast;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the JSON parsing operations.
 */
public class WeatherFetcherTest {

    private static final Logger LOGGER = Logger.getLogger(WeatherFetcherTest.class);

    @BeforeClass
    public static void beforeWeatherFetcherTest() {
        LOGGER.info("Start Fetcher's Forecast test");
    }

    @Test
    public void testForecastFormat()
    {
        try {
            String staticJson = "{\"coord\":{\"lon\":27.57,\"lat\":53.9},\"sys\":{\"message\":0.0298,\"country\":\"BY\",\"sunrise\":1393477287,\"sunset\":1393515796},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":3,\"pressure\":1023,\"humidity\":47,\"temp_min\":3,\"temp_max\":3},\"wind\":{\"speed\":3,\"deg\":110,\"var_beg\":80,\"var_end\":140},\"clouds\":{\"all\":0},\"dt\":1393500600,\"id\":625144,\"name\":\"Minsk\",\"cod\":200}";

            WeatherFetcher fetcher = new CurrentWeatherFetcher("Minsk");
            // spy on fetchJson() call in fetch() method.
            WeatherFetcher spy = spy(fetcher);
            when(spy.fetchJson()).thenReturn(staticJson);
            WeatherForecast forecast = spy.fetch();
            assertEquals(forecast.format(), "Minsk, BY (27.57,53.9): t=3.0°C, 1023atm");
            LOGGER.info("testForecastFormat() passed.");
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    @Test
    public void testWrongCity()
    {
        try {
            WeatherFetcher fetcher = new CurrentWeatherFetcher("qwerty");
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
