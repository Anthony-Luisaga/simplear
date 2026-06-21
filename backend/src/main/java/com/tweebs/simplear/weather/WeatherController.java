package com.tweebs.simplear.weather;

import com.tweebs.simplear.weather.dto.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@GetMapping
	public Mono<WeatherResponse> getWeather(
		@RequestParam double latitude,
		@RequestParam double longitude) {

		return service.getWeather(latitude, longitude);
	}
}
