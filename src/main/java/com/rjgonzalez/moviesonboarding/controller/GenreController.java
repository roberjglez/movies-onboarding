package com.rjgonzalez.moviesonboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rjgonzalez.moviesonboarding.dto.GenreRQDTO;
import com.rjgonzalez.moviesonboarding.dto.GenreRSDTO;
import com.rjgonzalez.moviesonboarding.service.GenreService;

/**
 * Controller to manage the genres
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@RestController
@RequestMapping({ "api/genre" })
public class GenreController {

	@Autowired
	GenreService genreService;

	/**
	 * Endpoint to add new genres
	 * 
	 * @param genreRQDTO -> genre with all the information
	 * @return ResponseEntity<GenreRSDTO> -> genre and http status
	 *
	 */
	@PostMapping(path = "/addGenre", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> addGenre(@RequestBody GenreRQDTO genreRQDTO) {

		return genreService.addGenre(genreRQDTO);

	}

	/**
	 * Endpoint to get a genre by ID
	 * 
	 * @param idGenre -> id genre that we want to get
	 * @return ResponseEntity<GenreRSDTO> -> genre and http status
	 *
	 */
	@GetMapping(path = "/getGenre/{idGenre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> getGenre(@PathVariable Long idGenre) {

		return genreService.getGenre(idGenre);

	}

	/**
	 * Endpoint to delete a genre by ID
	 * 
	 * @param idGenre -> id genre that we want to delete
	 * @return ResponseEntity<GenreRSDTO> -> genre and http status
	 *
	 */
	@DeleteMapping(path = "/deleteGenre/{idGenre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> deleteGenre(@PathVariable Long idGenre) {

		return genreService.deleteGenre(idGenre);

	}

	@GetMapping(path = "/getAllGenres", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<GenreRSDTO>> getAllGenres() {

		return genreService.getAllGenres();

	}

}
