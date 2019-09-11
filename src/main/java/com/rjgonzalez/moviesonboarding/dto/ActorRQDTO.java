package com.rjgonzalez.moviesonboarding.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * Actor request DTO
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ActorRQDTO {

	private Long idActor;

	private String name;

	private String surname;

	private String phoneNumber;

}
