package com.altissia.calculation.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.altissia.calculation.dto.CalculDTO;
import com.altissia.calculation.service.CalculService;

@ExtendWith(MockitoExtension.class)
class CalculEndpointTest {

	private CalculEndpoint calculEndpoint;

	@Mock
	private CalculService calculService;

	@BeforeEach
	void init() {
		this.calculEndpoint = new CalculEndpoint(calculService);
	}

	@Test
	void testReturningResult() {
		List<CalculDTO> expected = new ArrayList<CalculDTO>();
		expected.add(new CalculDTO(9, "fizz"));

		when(calculService.calcul(new int[] { 9 })).thenReturn(expected);

		List<CalculDTO> result = (List<CalculDTO>) calculEndpoint.calcul(new int[] { 9 });

		assertEquals(expected, result);
	}
}
