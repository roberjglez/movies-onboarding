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
import com.rjgonzalez.moviesonboarding.entity.ActorEntity;
import com.rjgonzalez.moviesonboarding.repository.ActorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorServiceImplTest {

	@MockBean
	private ActorRepository actorRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	private static final ObjectMapper om = new ObjectMapper();

	@Before
	public void init() {
		ActorEntity actor = new ActorEntity(1L, "Santiago", "Segura", "666777888");
		when(actorRepository.findById(1L)).thenReturn(Optional.of(actor));
	}

	@Test
	public void find_actorId_OK() throws JSONException {

		String expected = "{idActor:1,name:\"Santiago\",surname:\"Segura\",phoneNumber:\"666777888\"}";

		ResponseEntity<String> response = restTemplate.getForEntity("/actors/1", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		JSONAssert.assertEquals(expected, response.getBody(), false);

		verify(actorRepository, times(1)).findById(1L);

	}

	@Test
	public void find_allActor_OK() throws Exception {

		List<ActorEntity> actors = Arrays.asList(new ActorEntity(1L, "Ramon", "Jimenez", "123456"),
				new ActorEntity(2L, "Pepito", "Perez", "654321"));

		when(actorRepository.findAll()).thenReturn(actors);

		String expected = om.writeValueAsString(actors);

		ResponseEntity<String> response = restTemplate.getForEntity("/actors", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);

		verify(actorRepository, times(1)).findAll();
	}

	@Test
	public void find_actorIdNotFound_404() throws Exception {

		String expected = "{status:404,error:\"Not Found\"}";

		ResponseEntity<String> response = restTemplate.getForEntity("/actors/5", String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}
}
