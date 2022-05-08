package com.altissia.calculation.endpoint;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.altissia.calculation.CalculationApplication;
import com.altissia.calculation.dto.CalculDTO;

@SpringBootTest(classes = CalculationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CalculEndpointIT {

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate = null;

	@BeforeAll
	static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/fizzbuzz");
	}

	@Test
	void testWithEmptyEntry() {
		List<CalculDTO> result = restTemplate
				.exchange(baseUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<CalculDTO>>() {
				}).getBody();

		assertAll(() -> assertNotNull(result), () -> assertEquals(100, result.size()));

	}

	@Test
	void testWithNullEntry() {

		List<CalculDTO> result = restTemplate
				.exchange(baseUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<CalculDTO>>() {
				}).getBody();

		assertAll(() -> assertNotNull(result), () -> assertEquals(100, result.size()));

	}

	@Test
	void testWithFilled() {

		List<CalculDTO> expected = new ArrayList<>();
		expected.add(new CalculDTO(105, "FizzBuzzBazz"));
		expected.add(new CalculDTO(35, "BuzzBazz"));
		expected.add(new CalculDTO(21, "FizzBazz"));
		expected.add(new CalculDTO(14, "Bazz"));
		expected.add(new CalculDTO(30, "fizzbuzz"));
		expected.add(new CalculDTO(9, "fizz"));
		expected.add(new CalculDTO(20, "buzz"));
		expected.add(new CalculDTO(4, "4"));

		List<CalculDTO> result = restTemplate.exchange(baseUrl.concat("/105,35,21,14,30,9,20,4"), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CalculDTO>>() {
				}).getBody();

		assertAll(() -> assertNotNull(result), () -> assertEquals(8, result.size()),
				() -> assertEquals(expected, result, "input array"));

	}

}
