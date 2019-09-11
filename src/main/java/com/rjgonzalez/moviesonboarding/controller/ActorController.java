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

import com.rjgonzalez.moviesonboarding.dto.ActorRQDTO;
import com.rjgonzalez.moviesonboarding.dto.ActorRSDTO;
import com.rjgonzalez.moviesonboarding.service.ActorService;

@RestController
@RequestMapping({ "api/actor" })
public class ActorController {

	@Autowired
	ActorService actorService;

	@PostMapping(path = "/addActor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> addActor(@RequestBody ActorRQDTO actorRQDTO) {

		return actorService.addActor(actorRQDTO);

	}

	@PostMapping(path = "/getActor/{idActor}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> getActor(@PathVariable Long idActor) {

		return actorService.getActor(idActor);

	}

	@PostMapping(path = "/deleteActor/{idActor}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ActorRSDTO> deleteActor(@PathVariable Long idActor) {

		return actorService.deleteActor(idActor);

	}
}
