package com.rjgonzalez.moviesonboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rjgonzalez.moviesonboarding.dto.MovieRQDTO;
import com.rjgonzalez.moviesonboarding.dto.MovieRSDTO;
import com.rjgonzalez.moviesonboarding.service.MovieService;

@RestController
@RequestMapping({ "api/movie" })
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping(path = "/addMovie", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> addMovie(@RequestBody MovieRQDTO movieRQDTO) {

		return movieService.addMovie(movieRQDTO);

	}

	@PostMapping(path = "/getMovie/{idMovie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> getMovie(@PathVariable Long idMovie) {

		return movieService.getMovie(idMovie);

	}

	@PostMapping(path = "/deleteMovie/{idMovie}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MovieRSDTO> deleteMovie(@PathVariable Long idActor) {

		return movieService.deleteMovie(idActor);

	}

}
