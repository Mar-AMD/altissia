package com.altissia.calculation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.altissia.calculation.dto.CalculDTO;

class CalculServiceImplTest {

	private CalculService calculService;

	@BeforeEach
	void init() {
		this.calculService = new CalculServiceImpl();
	}

	@Test
	@DisplayName("Test multiple empty")
	void testEmptyInput() {

		List<CalculDTO> result = calculService.calcul(new int[] {});

		assertEquals(100, result.size());
	}

	@Test
	@DisplayName("Test input null")
	void testNullInput() {

		List<CalculDTO> result = calculService.calcul(null);

		assertEquals(100, result.size());
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	@DisplayName("Test output")
	void testParametersFromMethod(String expected, int entry) {
		String actual = calculService.calculer(entry);
		assertEquals(expected, actual, "test only output result");
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("FizzBuzzBazz", 105), Arguments.of("fizzbuzz", 15), Arguments.of("FizzBazz", 21),
				Arguments.of("BuzzBazz", 35), Arguments.of("fizz", 3), Arguments.of("buzz", 20),
				Arguments.of("Bazz", 28));
	}

	@Test
	@DisplayName("Test input array")
	void testMultipleSeven2() {
		int[] entry = { 14, 210, 30, 21, 8 };
		List<CalculDTO> actual = (List<CalculDTO>) calculService.calcul(entry);

		List<CalculDTO> expected = new ArrayList<CalculDTO>();
		expected.add(new CalculDTO(14, "Bazz"));
		expected.add(new CalculDTO(210, "FizzBuzzBazz"));
		expected.add(new CalculDTO(30, "fizzbuzz"));
		expected.add(new CalculDTO(21, "FizzBazz"));
		expected.add(new CalculDTO(8, "8"));

		assertEquals(expected, actual, "test input array");
	}

}
