package com.gfarm.moviecatlog.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.gfarm.moviecatlog.model.CatlogItem;
import com.gfarm.moviecatlog.model.Movie;
import com.gfarm.moviecatlog.model.Rating;
import com.gfarm.moviecatlog.model.UserRating;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogController {

	@Autowired
	private RestTemplate restTemplate; // way to call other microservices

//	@Autowired ***
//	private WebClient.Builder webClientBuilder;  

	@RequestMapping("/{userId}")
	// @HystrixCommand(fallbackMethod = "getFallbackCatlog") -- used at method where
	// we have to apply circuit breaker
	// as this method is giving many api calls
	// if circuit breaks we call the fallback method
	public List<CatlogItem> getCatlog(@PathVariable String userId) {

		// web client - equivalent to restTemplate ***
		// WebClient.Builder builder =WebClient.builder();

		// rest template ***
		// RestTemplate restTemplate = new RestTemplate();
		// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/foo",
		// Movie.class);
		// not a proper way to call other api using rest template
		// we are calling it inside the method
		// so every time it is going to create the new instance
		// and call the api again for every new request

//		return Collections.singletonList(
//				new CatlogItem("transformers", "test", 4)
//				);

// get all rated movie IDs
// for each movie id, call movie info service and get details 
// put them all together 

		// Hard coded
//		List<Rating> ratings = Arrays.asList(new Rating("123", 4),
//				new Rating("234", 3),
//				new Rating("345", 2),
//				new Rating("456", 5)
//				);
		// using restTemplte
		// get all rated movie IDs
//		UserRating ratings = restTemplate.getForObject("http://localhost:8083/rating/users/" + userId,
//				UserRating.class);

		// instead of calling api through url directly, consume it from eureka server
		// commenting to implement fallback at granuler level to avoid applying fallback
		// at main method
//		UserRating ratings = restTemplate.getForObject("http://movie-rating-service/rating/users/" + userId,
//				UserRating.class);

		UserRating ratings = getUserRating(userId);
		// commenting to implement fallback at granular level to avoid applying fallback
		// at main method
		// return ratings.getUserRating().stream().map(rating -> {
		// for each movie id, call movie info service and get details
		// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
		// rating.getMovieId(), Movie.class);
		// instead of calling api through url directly, consume it from eureka server

//			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//			// put them all together
//			return new CatlogItem(movie.getName(), "desc", rating.getRating());
//		}).toList();

		return ratings.getUserRating().stream().map(rating -> getCatlogItem(ratings).toList());

		// using webClient ***
//		return ratings.stream().map(rating -> {
//			
//			Movie movie = webClientBuilder.build().get()  //get method
//								.uri("http://localhost:8082/movies/" + rating.getMovieId()) // microservice url
//								.retrieve()   //retrieve data give it to class
//								.bodyToMono(Movie.class) //whatever body we are getting convert it into instance of given class
//								.block();
//			return new CatlogItem(movie.getName(), "desc", rating.getRating());
//			}).toList(); 

//		return Arrays.asList(
//				new CatlogItem("transformers", "test", 4)
//				);

	}

	// @HystrixCommand(fallbackMethod = "getFallbackgetUserRating")
	public UserRating getUserRating(@PathVariable String userId) {
		return restTemplate.getForObject("http://movie-rating-service/rating/users/" + userId, UserRating.class);
	}

	// @HystrixCommand(fallbackMethod = "getFallbackCatlogItem")
	public CatlogItem getCatlogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		// put them all together
		return new CatlogItem(movie.getName(), "desc", rating.getRating());
	}

	// fallback method - gives hard coded response when circuit breaks
	// same method signature
	public List<CatlogItem> getFallbackCatlog(@PathVariable String userId) {
		return Arrays.asList(new CatlogItem("no movie", "", 0));
	}

	public UserRating getFallbackUserRating(@PathVariable String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserRating(Arrays.asList(new Rating("0", 0)));
		return userRating;
	}

	public CatlogItem getFallbackCatlogItem(Rating rating) {
		return new CatlogItem("movieName", "desc", 0);
	}
}

//what we are doing wrong 
// hardcoded url  - changes require code updates
//				  - Dynamic URLs in the cloud
//				  - load balancing 
//				  - multiple environment 

//to over come this we have service discovery --Discovery Server 
// client side service discovery and server side service discovery
// spring cloud uses client side discovery
// Eureka server is where all the services are registered (publish) using eureka client
//				 have microservices locate (consume) using eurka client 
