package com.tweebs.simplear.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

	private static final Logger log =
		LoggerFactory.getLogger(WebClientConfig.class);


	@Bean
	@Qualifier("weatherWebClient")
	public WebClient weatherWebClient() {
		return WebClient.builder()
			.baseUrl("https://api.open-meteo.com")
			.filter(logRequest())
			.filter(logResponseBody())
			.build();
	}

	private ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(request -> {
			log.info(
				"HTTP {} {}",
				request.method(),
				request.url()
			);
			return Mono.just(request);
		});
	}

	private ExchangeFilterFunction logResponseBody() {
		return ExchangeFilterFunction.ofResponseProcessor(response ->
			response.bodyToMono(String.class)
				.doOnNext(body ->
					log.debug("HTTP response body: {}", body)
				)
				.map(body ->
					response.mutate()
						.body(body)
						.build()
				)
		);
	}

}
