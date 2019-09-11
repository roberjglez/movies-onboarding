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

import com.rjgonzalez.moviesonboarding.dto.GenreRQDTO;
import com.rjgonzalez.moviesonboarding.dto.GenreRSDTO;
import com.rjgonzalez.moviesonboarding.service.GenreService;

@RestController
@RequestMapping({ "api/genre" })
public class GenreController {

	@Autowired
	GenreService genreService;

	@PostMapping(path = "/addGenre", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> addGenre(@RequestBody GenreRQDTO genreRQDTO) {

		return genreService.addGenre(genreRQDTO);

	}

	@PostMapping(path = "/getGenre/{idGenre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> getGenre(@PathVariable Long idGenre) {

		return genreService.getGenre(idGenre);

	}

	@PostMapping(path = "/deleteGenre/{idGenre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GenreRSDTO> deleteGenre(@PathVariable Long idGenre) {

		return genreService.deleteGenre(idGenre);

	}

}
