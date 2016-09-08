package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;

@RestController
@RequestMapping("api/cities")
public class CityController {

	private final CityService cityService;
	
	@Autowired
	public CityController(CityService service) {
		super();
		this.cityService = service;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public City create(@RequestBody City city) {
		return this.cityService.create(city);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<City> index() {
		return this.cityService.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public City read(@PathVariable Integer id) {
		return this.cityService.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) 
	public City update(@PathVariable Integer id, @RequestBody City cityToUpdate) {
		return this.cityService.update(id, cityToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new Interest, or just old Interest
	public City delete(@PathVariable Integer id) {
		return this.cityService.delete(id);
	} 
	
	@RequestMapping(value="{id}/state", method=RequestMethod.GET)
	public State readState(@PathVariable Integer id) {
		return this.cityService.readState(id);
	}
	
	@RequestMapping(value="{id}/state", method=RequestMethod.PUT)
	public State putState(@PathVariable Integer id,@RequestBody State state) {
		return this.cityService.putState(id,state);
	}
}
