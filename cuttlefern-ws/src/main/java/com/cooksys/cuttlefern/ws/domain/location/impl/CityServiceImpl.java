package com.cooksys.cuttlefern.ws.domain.location.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityRepository;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository repo;

	@Autowired
	public CityServiceImpl(CityRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public City create(City city) {
		return this.repo.save(city);
	}

	@Override
	public List<City> index() {
		return this.repo.findAll();
	}

	@Override
	public City read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public City update(Integer id, City cityToUpdate) {
		cityToUpdate.setId(id);
		return this.repo.save(cityToUpdate);
	}

	@Override
	public City delete(Integer id) {
		City city = this.read(id);
		this.repo.delete(id);
		return city;
	}

	@Override
	public State readState(Integer id) {
		return this.repo.findOne(id).getState();
	}

	@Override
	public State putState(Integer id, State state) {
		City city = this.read(id);
		city.setState(state);
		this.repo.save(city);
		return city.getState();
	}
	
	
}
