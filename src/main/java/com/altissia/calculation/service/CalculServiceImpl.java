package com.altissia.calculation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.altissia.calculation.dto.CalculDTO;

@Service
public class CalculServiceImpl implements CalculService {

	@Override
	public List<CalculDTO> calcul(int[] entry) {
		List<CalculDTO> output = new ArrayList<>();

		if (entry == null || entry.length == 0) {
			entry = IntStream.rangeClosed(1, 100).toArray();
		}

		for (int i = 0; i < entry.length; i++) {
			CalculDTO c = new CalculDTO();
			c.setInput(entry[i]);
			c.setOutput(calculer(entry[i]));
			output.add(c);
		}

		return output;
	}

	@Override
	public String calculer(int entry) {
		String result = "";

		if (entry % 3 == 0 && entry % 5 == 0 && entry % 7 == 0)
			result = "FizzBuzzBazz";
		else if (entry % 3 == 0 && entry % 5 == 0)
			result = "fizzbuzz";
		else if (entry % 3 == 0 && entry % 7 == 0)
			result = "FizzBazz";
		else if (entry % 5 == 0 && entry % 7 == 0)
			result = "BuzzBazz";
		else if (entry % 3 == 0)
			result = "fizz";
		else if (entry % 5 == 0)
			result = "buzz";
		else if (entry % 7 == 0)
			result = "Bazz";
		else
			result = entry + "";

		return result;
	}

}
