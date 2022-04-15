package com.comcast.example.utils;

import java.util.Set;

import com.comcast.example.model.Movie;

public class MovieSetUtils {
    public void printMovieSetItemsWithSubstring(Set<Movie> movies, String substring) {
		for (Movie movie : movies) {
			if (movie.getName().contains(substring)) {
				System.out.println(movie.toString());
			}
		}
	}
	
	public void normalizeMovieTitles(Set<Movie> movies) {
		for (Movie movie : movies) {
			movie.setName(movie.getName().replaceAll("&", "and"));
		}
	}
}
