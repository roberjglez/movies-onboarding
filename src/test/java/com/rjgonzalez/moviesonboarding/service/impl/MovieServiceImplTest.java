package com.rjgonzalez.moviesonboarding.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rjgonzalez.moviesonboarding.entity.ActorEntity;
import com.rjgonzalez.moviesonboarding.entity.GenreEntity;
import com.rjgonzalez.moviesonboarding.entity.MovieEntity;
import com.rjgonzalez.moviesonboarding.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceImplTest {

	@MockBean
	private MovieRepository movieRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void init() {
		ActorEntity actorEntity = new ActorEntity(1L, "Juan", "Ramirez", "1342342");
		GenreEntity genreEntity = new GenreEntity(1L, "suspense");
		List<GenreEntity> listGenres = new ArrayList<GenreEntity>();
		listGenres.add(genreEntity);
		List<ActorEntity> listActors = new ArrayList<ActorEntity>();
		listActors.add(actorEntity);
		MovieEntity actor = new MovieEntity(1L, "Casa de Papel", "2019", listActors, listGenres);
		when(movieRepository.findById(1L)).thenReturn(Optional.of(actor));
	}

	@Test
	public void find_movieIdNotFound_404() throws Exception {

		String expected = "{status:404,error:\"Not Found\"}";

		ResponseEntity<String> response = restTemplate.getForEntity("/movies/5", String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}
}
