package com.altissia.calculation.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class CalculServiceImpl implements CalculService {

	@Override
	public Map<Integer, String> calcul(int[] entry) {
		Map<Integer, String> result = new HashMap<>();

		if (entry == null || entry.length == 0)
			result.put(0, Arrays.toString(IntStream.rangeClosed(1, 100).toArray()));
		else {
			for (int i = 0; i < entry.length; i++) {
				if (entry[i] % 3 == 0 & entry[i] % 5 == 0 & entry[i] % 7 == 0)
					result.put(entry[i], "FizzBuzzBazz");
				else if (entry[i] % 3 == 0 & entry[i] % 5 == 0)
					result.put(entry[i], "fizzbuzz");
				else if (entry[i] % 3 == 0 & entry[i] % 7 == 0)
					result.put(entry[i], "FizzBazz");
				else if (entry[i] % 5 == 0 & entry[i] % 7 == 0)
					result.put(entry[i], "BuzzBazz");
				else if (entry[i] % 3 == 0)
					result.put(entry[i], "fizz");
				else if (entry[i] % 5 == 0)
					result.put(entry[i], "buzz");
				else if (entry[i] % 7 == 0)
					result.put(entry[i], "Bazz");
				else
					result.put(entry[i], entry[i] + "");
			}

		}
		return result;
	}

}
