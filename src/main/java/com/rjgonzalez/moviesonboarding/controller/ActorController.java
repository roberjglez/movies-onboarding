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

import com.rjgonzalez.moviesonboarding.dto.ActorRQDTO;
import com.rjgonzalez.moviesonboarding.dto.ActorRSDTO;
import com.rjgonzalez.moviesonboarding.service.ActorService;

/**
 * Controller to manage the actors
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@RestController
@RequestMapping({ "api/actor" })
public class ActorController {

	@Autowired
	ActorService actorService;

	/**
	 * Endpoint to add new actors
	 * 
	 * @param actorRQDTO -> actor with all the information
	 * @return ResponseEntity<ActorRSDTO> -> actor and http status
	 *
	 */
	@PostMapping(path = "/addActor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> addActor(@RequestBody ActorRQDTO actorRQDTO) {

		return actorService.addActor(actorRQDTO);

	}

	/**
	 * Endpoint to get an actor by ID
	 * 
	 * @param idActor -> id actor that we want to get
	 * @return ResponseEntity<ActorRSDTO> -> actor and http status
	 *
	 */
	@GetMapping(path = "/getActor/{idActor}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> getActor(@PathVariable Long idActor) {

		return actorService.getActor(idActor);

	}

	/**
	 * Endpoint to delete an actor by ID
	 * 
	 * @param idActor -> id actor that we want to delete
	 * @return ResponseEntity<ActorRSDTO> -> actor and http status
	 *
	 */
	@DeleteMapping(path = "/deleteActor/{idActor}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> deleteActor(@PathVariable Long idActor) {

		return actorService.deleteActor(idActor);

	}

	/**
	 * Endpoint to get all actors
	 * 
	 * @return ResponseEntity<List<ActorRSDTO>> -> actors list and http status
	 *
	 */
	@GetMapping(path = "/getAllActors", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ActorRSDTO>> getAllActors() {

		return actorService.getAllActors();

	}
}
