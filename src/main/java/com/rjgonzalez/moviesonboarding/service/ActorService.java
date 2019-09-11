package com.rjgonzalez.moviesonboarding.service;

import org.springframework.http.ResponseEntity;

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
}
