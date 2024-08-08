package com.gfarm.movieservice.model;

public class Movie {
	private String movieId;
	private String name;
	private String overview;
	
	
	public Movie() {
		super();
	}

	public Movie(String movieId, String name, String overview) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.overview = overview;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
