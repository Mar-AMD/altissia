package com.altissia.calculation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculServiceTest {

	@Autowired
	private CalculService calculService;

	@Test
	void testMultipleThreeAndFiveAndSeven() {
		int[] b = { 105 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(105, "FizzBuzzBazz");
		assertEquals(expected, actual, "test multiple 3, 5 and 7");
	}

	@Test
	void testMultipleThreeAndFive() {
		int[] b = { 30 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(30, "fizzbuzz");
		assertEquals(expected, actual, "test multiple 3, 5");
	}

	@Test
	void testMultipleThreeAndSeven() {
		int[] b = { 21 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(21, "FizzBazz");
		assertEquals(expected, actual, "test multiple 3 and 7");
	}

	@Test
	void testMultipleFiveAndSeven() {
		int[] b = { 35 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(35, "BuzzBazz");
		assertEquals(expected, actual, "test multiple 5 and 7");
	}

	@Test
	void testMultipleThree() {
		int[] b = { 9 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(9, "fizz");
		assertEquals(expected, actual, "test multiple 3");
	}

	@Test
	void testMultipleFive() {
		int[] b = { 20 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(20, "buzz");
		assertEquals(expected, actual, "test multiple 5");
	}

	@Test
	void testMultipleSeven() {
		int[] b = { 14 };
		Map<Integer, String> actual = calculService.calcul(b);
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(14, "Bazz");
		assertEquals(expected, actual, "test multiple 7");
	}

}
