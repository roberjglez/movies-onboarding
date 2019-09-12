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

import com.rjgonzalez.moviesonboarding.dto.MovieRQDTO;
import com.rjgonzalez.moviesonboarding.dto.MovieRSDTO;
import com.rjgonzalez.moviesonboarding.service.MovieService;

/**
 * Controller to manage the movies
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@RestController
@RequestMapping({ "api/movie" })
public class MovieController {

	@Autowired
	MovieService movieService;

	/**
	 * Endpoint to add new movies
	 * 
	 * @param movieRQDTO -> movie with all the information
	 * @return ResponseEntity<MovieRSDTO> -> movie and http status
	 *
	 */
	@PostMapping(path = "/addMovie", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> addMovie(@RequestBody MovieRQDTO movieRQDTO) {

		return movieService.addMovie(movieRQDTO);

	}

	/**
	 * Endpoint to get a movie by ID
	 * 
	 * @param idMovie -> id movie that we want to get
	 * @return ResponseEntity<MovieRSDTO> -> movie and http status
	 *
	 */
	@GetMapping(path = "/getMovie/{idMovie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> getMovie(@PathVariable Long idMovie) {

		return movieService.getMovie(idMovie);

	}

	/**
	 * Endpoint to delete a movie by ID
	 * 
	 * @param idMovie -> id movie that we want to delete
	 * @return ResponseEntity<MovieRSDTO> -> movie and http status
	 *
	 */
	@DeleteMapping(path = "/deleteMovie/{idMovie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> deleteMovie(@PathVariable Long idMovie) {

		return movieService.deleteMovie(idMovie);

	}

	/**
	 * Endpoint to get all movies
	 * 
	 * @return ResponseEntity<List<MovieRSDTO>> -> movies list and http status
	 *
	 */
	@GetMapping(path = "/getAllMovies", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<MovieRSDTO>> getAllMovies() {

		return movieService.getAllMovies();

	}

}
