package com.gfarm.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gfarm.movieservice.model.Movie;
import com.gfarm.movieservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
	
	
	//external api call
	@Value("${api.key}")
	private String apiKey; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable String movieId) {
		//return new Movie(userId, "test name");  //hard coded
		
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
				"api_key=" + apiKey, MovieSummary.class);
		
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}
