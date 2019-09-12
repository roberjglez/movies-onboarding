package com.rjgonzalez.moviesonboarding.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Actor request DTO
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRQDTO {

	private Long idActor;

	private String name;

	private String surname;

	private String phoneNumber;

	/**
	 * @return the idActor
	 */
	public Long getIdActor() {
		return idActor;
	}

	/**
	 * @param idActor the idActor to set
	 */
	public void setIdActor(Long idActor) {
		this.idActor = idActor;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
