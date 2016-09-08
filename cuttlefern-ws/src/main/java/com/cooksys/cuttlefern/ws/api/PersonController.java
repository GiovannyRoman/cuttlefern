package com.cooksys.cuttlefern.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@RestController
@RequestMapping("api/people")
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService service){
		super();
		this.personService = service;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return this.personService.create(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> index() {
		return this.personService.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Person read(@PathVariable Integer id) {
		return this.personService.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH)
	public Person update(@PathVariable Integer id, @RequestBody Person personToUpdate) {
		return this.personService.update(id, personToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public Person delete(@PathVariable Integer id) {
		return this.personService.delete(id);
	}
	
	@RequestMapping(value="{id}/interests", method=RequestMethod.GET)
	public Set<Interest> readInterests(@PathVariable Integer id) {
		return this.personService.readInterests(id);
	}
	
	@RequestMapping(value="{id}/interests", method=RequestMethod.PUT)
	public Set<Interest> putInterests(@PathVariable Integer id,@RequestBody Set<Interest> interests) {
		return this.personService.putInterests(id,interests);
	}
	
	@RequestMapping(value="{id}/interests/{interest_id}", method=RequestMethod.PUT)
	public Interest deleteInterests(@PathVariable Integer id,@PathVariable Integer interest_id) {
		return this.personService.deleteInterests(id,interest_id);
	}
	
	@RequestMapping(value="{id}/groups",method=RequestMethod.GET)
	public Set<Group> readGroups(@PathVariable Integer id){
		return this.personService.readGroups(id);
	}
	
	@RequestMapping(value="{id}/groups",method=RequestMethod.PUT)
	public Set<Group> putGroups(@PathVariable Integer id,@RequestBody Set<Group> groups){
		return this.personService.putGroups(id,groups);
	}
	
	@RequestMapping(value="{id}/groups/{group_id}",method=RequestMethod.DELETE)
	public Group deleteGroups(@PathVariable Integer id,@PathVariable Integer group_id){
		return this.personService.deleteGroups(id,group_id);
	}
}
