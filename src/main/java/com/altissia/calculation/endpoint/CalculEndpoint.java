package com.altissia.calculation.endpoint;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altissia.calculation.dto.CalculDTO;
import com.altissia.calculation.service.CalculService;

@RestController
public class CalculEndpoint {

	private final CalculService calculService;

	public CalculEndpoint(CalculService calculService) {
		this.calculService = calculService;
	}

	@GetMapping(value = { "/fizzbuzz/{entry}", "/fizzbuzz/", "/fizzbuzz" })
	public List<CalculDTO> calcul(@PathVariable(required = false) int[] entry) {

		return calculService.calcul(entry);

	}

}
