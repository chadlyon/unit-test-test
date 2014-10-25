package com.comcast.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import com.comcast.example.model.Movie;

public class MovieSetExample {

	public static void main(String[] args) {
		String fileName = "src/main/resources/movies.csv";

		Set<Movie> movies = loadMoviesFromFile(fileName);

		printMovieSetItemsWithSubstring(movies, "&");

		normalizeMovieTitles(movies);

		System.out.println("\n------------------------\n");

		printMovieSetItemsWithSubstring(movies, "and");
		
		Movie testMovie1 = new Movie("Benny and Joon", 1993);

		System.out.println("\nSet Contains " + testMovie1.toString() + ": "
				+ movies.contains(testMovie1));
	}

	public static Set<Movie> loadMoviesFromFile(String fileName) {
		HashSet<Movie> movies = new HashSet<Movie>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					fileName)));

			String curLine = reader.readLine();
			while (curLine != null) {
				String[] parts = curLine.split("\t");
				Movie movie = new Movie(parts[0], 0);
				try {
					movie.setRelease_year(Integer.parseInt(parts[1]));
				} catch (NumberFormatException e) {
					curLine = reader.readLine();
					continue;
				}
				movies.add(movie);
				curLine = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return movies;
	}
	
	public static void printMovieSetItemsWithSubstring(Set<Movie> movies, String substring) {
		for (Movie movie : movies) {
			if (movie.getName().contains(substring)) {
				System.out.println(movie.toString());
			}
		}
	}
	
	public static void normalizeMovieTitles(Set<Movie> movies) {
		for (Movie movie : movies) {
			movie.setName(movie.getName().replaceAll("&", "and"));
		}
	}
}
