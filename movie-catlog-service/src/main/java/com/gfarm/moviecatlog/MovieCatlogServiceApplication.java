package com.gfarm.moviecatlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//@EnableEurekaClient  -- acts as euraka client
//@EnableCirCuitBreaker  -- for circuit breaking 
public class MovieCatlogServiceApplication {
	
	@Bean
	public RestTemplate getrestTemplate() {
		//return new RestTemplate();
		//setting a time out incase of api call failure or slow instance 
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
								new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}
	@Bean
	public WebClient.Builder getWebClient() {
		return  WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatlogServiceApplication.class, args);
	}

}
