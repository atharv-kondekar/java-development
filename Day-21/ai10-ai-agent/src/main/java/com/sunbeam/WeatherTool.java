package com.sunbeam;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherTool {
	@Value("${openweather.api.key}")
	private String openWeatherApiKey;

	private RestClient restClient;
	public WeatherTool(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://api.openweathermap.org").build();
    }

    @Tool(description = "This tool finds the current/live weather of a given city in JSON string. Do not use this for historic/general weather conditions.")
    public String getCurrentWeather(String city) {
        try {
        	System.out.println("Getting Weather of " + city);
            String weather = this.restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/data/2.5/weather")
                            .queryParam("q", city)
                            .queryParam("appid", openWeatherApiKey)
                            .queryParam("units", "metric")
                            .build())
                    .retrieve()
                    .body(String.class); // Returns raw JSON text string
            System.out.println("WEATHER: " + weather);
            return weather;
        } catch (Exception e) {
            return "{\"ERROR\": "+ e.getMessage() +"}";
        }
    }
}
