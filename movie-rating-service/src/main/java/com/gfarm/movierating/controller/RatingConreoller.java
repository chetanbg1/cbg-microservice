package com.gfarm.movierating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfarm.movierating.model.Rating;
import com.gfarm.movierating.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingConreoller {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId , 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		List<Rating> rating = Arrays.asList(
				new Rating("123" , 4),
				new Rating("234" , 2),
				new Rating("345" , 5)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(rating);
		return userRating;
	}
}
