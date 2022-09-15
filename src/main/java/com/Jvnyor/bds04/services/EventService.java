package com.Jvnyor.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Jvnyor.bds04.dto.EventDTO;
import com.Jvnyor.bds04.entities.Event;
import com.Jvnyor.bds04.repositories.CityRepository;
import com.Jvnyor.bds04.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	private CityRepository cityRepository;
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event event = repository.save(dtoToEntity(dto));
		return new EventDTO(event);
	}

	@Transactional(readOnly = true)
	public Page<EventDTO> findAll(Pageable pageable) {
		Page<Event> events = repository.findAll(pageable);
		return events.map(x -> new EventDTO(x));
	}
	
	private Event dtoToEntity(EventDTO dto) {
		Event event = new Event();
		event.setId(dto.getId());
		event.setName(dto.getName());
		event.setDate(dto.getDate());
		event.setUrl(dto.getUrl());
		event.setCity(cityRepository.findById(dto.getCityId()).orElse(null));
		return event;
	}
}
