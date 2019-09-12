package com.rjgonzalez.moviesonboarding.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Movie response DTO
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRSDTO {

	private Long idMovie;

	private String title;

	private String year;

	private List<ActorRQDTO> actors;

	private List<GenreRQDTO> genres;

	/**
	 * @return the idMovie
	 */
	public Long getIdMovie() {
		return idMovie;
	}

	/**
	 * @param idMovie the idMovie to set
	 */
	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the actors
	 */
	public List<ActorRQDTO> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<ActorRQDTO> actors) {
		this.actors = actors;
	}

	/**
	 * @return the genres
	 */
	public List<GenreRQDTO> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<GenreRQDTO> genres) {
		this.genres = genres;
	}

}
