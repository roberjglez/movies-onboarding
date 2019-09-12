package com.rjgonzalez.moviesonboarding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Genre Entity
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@Entity
@Table(name = "Genres")
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genre")
	private Long idGenre;

	@Column(name = "type")
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
