package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateService;

@RestController
@RequestMapping("api/states")
public class StateController {
	
	private final StateService stateService;
	
	@Autowired
	public StateController(StateService service) {
		super();
		this.stateService = service;
	}
	@RequestMapping(method=RequestMethod.POST)
	public State create(@RequestBody State state) {
		return this.stateService.create(state);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<State> index() {
		return this.stateService.index();
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public State read(@PathVariable Integer id) {
		return this.stateService.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) 
	public State update(@PathVariable Integer id, @RequestBody State stateToUpdate) {
		return this.stateService.update(id, stateToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) 
	public State delete(@PathVariable Integer id) {
		return this.stateService.delete(id);
	} 
}
