package com.rjgonzalez.moviesonboarding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Actor Entity
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@Entity
@Table(name = "Actors")
public class ActorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_actor")
	private Long idActor;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "surname", nullable = false)
	private String surname;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	public ActorEntity(Long idActor, String name, String surname, String phoneNumber) {
		super();
		this.idActor = idActor;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

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
