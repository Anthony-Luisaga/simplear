package com.tweebs.simplear.weather;

import com.tweebs.simplear.weather.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherClient {

	private final WebClient webClient;

	public WeatherClient(
		@Qualifier("weatherWebClient") WebClient webClient) {
		this.webClient = webClient;
	}


	public Mono<WeatherResponse> getWeather(double latitude, double longitude) {

		return webClient.get()
			.uri(uriBuilder -> uriBuilder
				.path("/v1/forecast")
				.queryParam("latitude", latitude)
				.queryParam("longitude", longitude)
				.queryParam("current_weather", true)
				.build()
			)
			.retrieve()
			.bodyToMono(WeatherResponse.class);
	}
}
