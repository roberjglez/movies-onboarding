package com.rjgonzalez.moviesonboarding.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * Movie request DTO
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MovieRQDTO {

	private Long idMovie;

	private String title;

	private String year;

}
