package com.rjgonzalez.moviesonboarding.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rjgonzalez.moviesonboarding.dto.ActorRQDTO;
import com.rjgonzalez.moviesonboarding.dto.ActorRSDTO;

/**
 * 
 * Interface service for manage actors
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
public interface ActorService {

	public ResponseEntity<ActorRSDTO> addActor(ActorRQDTO actorRQDTO);

	public ResponseEntity<ActorRSDTO> deleteActor(Long idActor);

	public ResponseEntity<ActorRSDTO> getActor(Long idActor);

	public ResponseEntity<List<ActorRSDTO>> getAllActors();
}
