package com.rjgonzalez.moviesonboarding.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjgonzalez.moviesonboarding.entity.GenreEntity;
import com.rjgonzalez.moviesonboarding.repository.GenreRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreServiceImplTest {

	@MockBean
	private GenreRepository genreRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	private static final ObjectMapper om = new ObjectMapper();

	@Before
	public void init() {
		GenreEntity genre = new GenreEntity(1L, "Suspense");
		when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));
	}

	@Test
	public void find_genreId_OK() throws JSONException {

		String expected = "{idGenre:1,type:\"Suspense\"}";

		ResponseEntity<String> response = restTemplate.getForEntity("/genres/1", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		JSONAssert.assertEquals(expected, response.getBody(), false);

		verify(genreRepository, times(1)).findById(1L);

	}

	@Test
	public void find_allGenre_OK() throws Exception {

		List<GenreEntity> genres = Arrays.asList(new GenreEntity(1L, "Suspense"), new GenreEntity(2L, "Drama"));

		when(genreRepository.findAll()).thenReturn(genres);

		String expected = om.writeValueAsString(genres);

		ResponseEntity<String> response = restTemplate.getForEntity("/genres", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);

		verify(genreRepository, times(1)).findAll();
	}

	@Test
	public void find_genreIdNotFound_404() throws Exception {

		String expected = "{status:404,error:\"Not Found\"}";

		ResponseEntity<String> response = restTemplate.getForEntity("/genres/5", String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}
}
