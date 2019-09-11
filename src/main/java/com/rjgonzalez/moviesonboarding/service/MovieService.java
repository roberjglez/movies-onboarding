package com.rjgonzalez.moviesonboarding.service;

import org.springframework.http.ResponseEntity;

/**
 * 
 * Interface service for manage movies
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
public interface MovieService {

	public ResponseEntity<MovieRSDTO> addMovie(MovieRQDTO movieRQDTO);

	public ResponseEntity<MovieRSDTO> deleteMovie(Long idMovie);

	public ResponseEntity<MovieRSDTO> getMovie(Long idMovie);
}