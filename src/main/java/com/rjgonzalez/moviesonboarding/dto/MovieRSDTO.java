package com.rjgonzalez.moviesonboarding.dto;

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

}
