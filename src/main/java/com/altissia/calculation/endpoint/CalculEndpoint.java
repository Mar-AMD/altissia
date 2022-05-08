package com.altissia.calculation.endpoint;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altissia.calculation.service.CalculService;

@RestController
public class CalculEndpoint {
	@Autowired
	private CalculService calculService;

	@GetMapping(value = { "/fizzbuzz/{entry}", "/fizzbuzz/", "/fizzbuzz" })
	public Map<Integer, String> calcul(@PathVariable(required = false) int[] entry) {

		return calculService.calcul(entry);

	}

}
