package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;

@RestController
@RequestMapping("api/interests")
public class InterestController {
	
	private final InterestService service;
	
	@Autowired
	public InterestController(InterestService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Interest create(@RequestBody Interest interest) {
		return this.service.create(interest);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Interest> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Interest read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Interest, or just old Interest
	public Interest update(@PathVariable Integer id, @RequestBody Interest interestToUpdate) {
		return this.service.update(id, interestToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new Interest, or just old Interest
	public Interest delete(@PathVariable Integer id) {
		return this.service.delete(id);
	} 
	
}
