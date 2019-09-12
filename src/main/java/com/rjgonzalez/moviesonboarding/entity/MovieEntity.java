package com.rjgonzalez.moviesonboarding.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Movie Entity
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@Entity
@Table(name = "Movies")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movie")
	private Long idMovie;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "movies_have_actors", joinColumns = @JoinColumn(name = "id_movie", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_actor", nullable = false))
	private List<ActorEntity> actors;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "movies_have_genres", joinColumns = @JoinColumn(name = "id_movie", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_genre", nullable = false))
	private List<GenreEntity> genres;

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
	public List<ActorEntity> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<ActorEntity> actors) {
		this.actors = actors;
	}

	/**
	 * @return the genres
	 */
	public List<GenreEntity> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<GenreEntity> genres) {
		this.genres = genres;
	}

}
