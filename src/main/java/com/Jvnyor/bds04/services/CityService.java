package com.Jvnyor.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Jvnyor.bds04.dto.CityDTO;
import com.Jvnyor.bds04.entities.City;
import com.Jvnyor.bds04.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	@Transactional
	public CityDTO insert(CityDTO dto) {
		City city = repository.save(new City(dto));
		return new CityDTO(city);
	}

	@Transactional(readOnly = true)
	public List<CityDTO> findAll() {
		List<City> cities = repository.findAll(Sort.by("name"));
		return cities.stream()
				.map(x -> new CityDTO(x))
				.collect(Collectors.toList());
	}
}
