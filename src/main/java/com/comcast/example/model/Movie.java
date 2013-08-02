package com.comcast.example.model;

public class Movie {
	private String name;
	private Integer release_year;

	public Movie(String name, Integer releaseYear) {
		if (name == null) {
			throw new IllegalArgumentException("Movie name cannot be null");
		}
		if (releaseYear == null) {
			throw new IllegalArgumentException("Movie releaseYear cannot be null");
		}
		this.name = name;
		this.release_year = releaseYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	@Override
	public boolean equals(Object other) {
		Movie oMovie = (Movie) other;
		return this.name.equals(oMovie.getName())
				&& (int) this.getRelease_year() == (int) oMovie.getRelease_year();
	}

	//@Override
	//public int hashCode() {
//		return this.name.hashCode() + (release_year != null ? release_year.hashCode() : 0);
	//}

	@Override
	public String toString() {
		String yearPart = release_year != null ? " (" + release_year + ")" : "";
		return name + yearPart;
	}
}
