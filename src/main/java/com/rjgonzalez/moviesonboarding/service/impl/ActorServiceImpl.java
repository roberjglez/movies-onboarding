package com.rjgonzalez.moviesonboarding.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rjgonzalez.moviesonboarding.dto.ActorRQDTO;
import com.rjgonzalez.moviesonboarding.dto.ActorRSDTO;
import com.rjgonzalez.moviesonboarding.entity.ActorEntity;
import com.rjgonzalez.moviesonboarding.repository.ActorRepository;
import com.rjgonzalez.moviesonboarding.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ActorRepository actorRepository;

	@Override
	public ResponseEntity<ActorRSDTO> addActor(ActorRQDTO actorRQDTO) {

		ActorEntity actorRQEntity = modelMapper.map(actorRQDTO, ActorEntity.class);

		ActorEntity actorRSEntity = actorRepository.save(actorRQEntity);

		ActorRSDTO actorResponse = modelMapper.map(actorRSEntity, ActorRSDTO.class);

		return new ResponseEntity<>(actorResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ActorRSDTO> deleteActor(Long idActor) {

		actorRepository.deleteById(idActor);

		ActorRSDTO actorRSEntity = new ActorRSDTO();

		return new ResponseEntity<>(actorRSEntity, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ActorRSDTO> getActor(Long idActor) {

		Optional<ActorEntity> actorEntity = actorRepository.findById(idActor);

		if (actorEntity.isPresent()) {

			ActorRSDTO actorResponse = modelMapper.map(actorEntity.get(), ActorRSDTO.class);

			return new ResponseEntity<>(actorResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
