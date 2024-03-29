package com.Jvnyor.bds04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.bds04.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
