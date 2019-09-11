package com.rjgonzalez.moviesonboarding.service;

import org.springframework.http.ResponseEntity;

/**
 * 
 * Interface service for manage genres
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
public interface GenreService {

	public ResponseEntity<GenreRSDTO> addGenre(GenreRQDTO genreRQDTO);

	public ResponseEntity<GenreRSDTO> deleteGenre(Long idGenre);

	public ResponseEntity<GenreRSDTO> getGenre(Long idGenre);
}
