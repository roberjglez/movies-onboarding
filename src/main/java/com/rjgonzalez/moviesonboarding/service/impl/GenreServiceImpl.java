package com.rjgonzalez.moviesonboarding.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rjgonzalez.moviesonboarding.dto.GenreRQDTO;
import com.rjgonzalez.moviesonboarding.dto.GenreRSDTO;
import com.rjgonzalez.moviesonboarding.entity.GenreEntity;
import com.rjgonzalez.moviesonboarding.repository.GenreRepository;
import com.rjgonzalez.moviesonboarding.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	GenreRepository genreRepository;

	@Override
	public ResponseEntity<GenreRSDTO> addGenre(GenreRQDTO genreRQDTO) {

		GenreEntity actorRQEntity = modelMapper.map(genreRQDTO, GenreEntity.class);

		GenreEntity genreRSEntity = genreRepository.save(actorRQEntity);

		GenreRSDTO genreResponse = modelMapper.map(genreRSEntity, GenreRSDTO.class);

		return new ResponseEntity<>(genreResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenreRSDTO> deleteGenre(Long idGenre) {

		genreRepository.deleteById(idGenre);

		GenreRSDTO genreRSEntity = new GenreRSDTO();

		return new ResponseEntity<>(genreRSEntity, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<GenreRSDTO> getGenre(Long idGenre) {

		Optional<GenreEntity> genreEntity = genreRepository.findById(idGenre);

		if (genreEntity.isPresent()) {

			GenreRSDTO genreResponse = modelMapper.map(genreEntity.get(), GenreRSDTO.class);

			return new ResponseEntity<>(genreResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
