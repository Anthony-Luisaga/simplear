package com.tweebs.simplear.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

	private double latitude;
	private double longitude;

	@JsonProperty("generationtime_ms")
	private double generationTimeMs;


	@JsonProperty("utc_offset_seconds")
	private double utcOffsetSeconds;

	private String timezone;

	@JsonProperty("timezone_abbreviation")
	private String timezoneAbbreviation;

	private double elevation;

	@JsonProperty("current_weather")
	private CurrentWeather currentWeather;

	@Setter
	@Getter
	public static class CurrentWeather {
		private double temperature;

		@JsonProperty("windspeed")
		private double windSpeed;

		@JsonProperty("winddirection")
		private double windDirection;

		@JsonProperty("weathercode")
		private int weatherCode;

		@JsonProperty("is_day")
		private boolean isDay;

		private String time;
	}
}
