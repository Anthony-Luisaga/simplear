package com.tweebs.simplear.weather;

import com.tweebs.simplear.weather.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

	private final WeatherClient client;

	public WeatherService(WeatherClient client) {
		this.client = client;
	}

	public Mono<WeatherResponse> getWeather(double latitude, double longitude) {
		return client.getWeather(latitude, longitude);
	}
}
