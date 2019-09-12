package com.rjgonzalez.moviesonboarding.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Genre response DTO
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreRSDTO {

	private Long idGenre;

	private String type;

	/**
	 * @return the idGenre
	 */
	public Long getIdGenre() {
		return idGenre;
	}

	/**
	 * @param idGenre the idGenre to set
	 */
	public void setIdGenre(Long idGenre) {
		this.idGenre = idGenre;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
