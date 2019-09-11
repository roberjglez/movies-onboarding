package com.rjgonzalez.moviesonboarding.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Movie Entity
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@Entity
@Data
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

	@ManyToMany
	@JoinTable(name = "movies_have_actors", joinColumns = @JoinColumn(name = "id_movie", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_actor", nullable = false))
	private List<ActorEntity> actors;

	@ManyToMany
	@JoinTable(name = "movies_have_genres", joinColumns = @JoinColumn(name = "id_movie", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_genre", nullable = false))
	private List<GenreEntity> genres;
}
