package com.altissia.calculation.service;

import java.util.List;

import com.altissia.calculation.dto.CalculDTO;

public interface CalculService {

	public List<CalculDTO> calcul(int[] entry);

	public String calculer(int entry);

}
