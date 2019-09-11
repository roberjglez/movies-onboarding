package com.rjgonzalez.moviesonboarding.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rjgonzalez.moviesonboarding.dto.MovieRQDTO;
import com.rjgonzalez.moviesonboarding.dto.MovieRSDTO;
import com.rjgonzalez.moviesonboarding.entity.MovieEntity;
import com.rjgonzalez.moviesonboarding.repository.MovieRepository;
import com.rjgonzalez.moviesonboarding.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public ResponseEntity<MovieRSDTO> addMovie(MovieRQDTO movieRQDTO) {

		MovieEntity movieRQEntity = modelMapper.map(movieRQDTO, MovieEntity.class);

		MovieEntity movieRSEntity = movieRepository.save(movieRQEntity);

		MovieRSDTO movieResponse = modelMapper.map(movieRSEntity, MovieRSDTO.class);

		return new ResponseEntity<>(movieResponse, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<MovieRSDTO> deleteMovie(Long idMovie) {

		movieRepository.deleteById(idMovie);

		MovieRSDTO movieRSEntity = new MovieRSDTO();

		return new ResponseEntity<>(movieRSEntity, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<MovieRSDTO> getMovie(Long idMovie) {

		Optional<MovieEntity> movieEntity = movieRepository.findById(idMovie);

		if (movieEntity.isPresent()) {

			MovieRSDTO movieResponse = modelMapper.map(movieEntity.get(), MovieRSDTO.class);

			return new ResponseEntity<>(movieResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
