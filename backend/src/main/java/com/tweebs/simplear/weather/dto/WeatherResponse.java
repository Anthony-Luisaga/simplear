package com.tweebs.simplear.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class WeatherResponse {

//	@JsonProperty("current_weather")
	private CurrentWeather current_weather;

	@Setter
	@Getter
	public static class CurrentWeather {
		private double temperature;
		private double windspeed;

	}

	public CurrentWeather getCurrent_weather() {
		return current_weather;
	}

	public void setCurrent_weather(CurrentWeather current_weather) {
		this.current_weather = current_weather;
	}
}
