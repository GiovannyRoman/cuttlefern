package com.cooksys.cuttlefern.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;

@RestController
@RequestMapping("api/groups")
public class GroupController {

	private final GroupService groupService;
	
	public GroupController(GroupService service){
		super();
		this.groupService = service;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Group create(@RequestBody Group group) {
		return this.groupService.create(group);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Group> index() {
		return this.groupService.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Group read(@PathVariable Integer id) {
		return this.groupService.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) 
	public Group update(@PathVariable Integer id, @RequestBody Group groupToUpdate) {
		return this.groupService.update(id, groupToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) 
	public Group delete(@PathVariable Integer id) {
		return this.groupService.delete(id);
	} 
	
	@RequestMapping(value="{id}/interest",method=RequestMethod.GET)
	public Interest getInterest(@PathVariable Integer id){
		return this.groupService.getInterest(id);
	}
	
	@RequestMapping(value="{id}/interest",method=RequestMethod.PUT)
	public Interest putInterest(@PathVariable Integer id,Interest interest){
		return this.groupService.putInterest(id,interest);
	}
	
	@RequestMapping(value="{id}/city",method=RequestMethod.GET)
	public City getCity(@PathVariable Integer id){
		return this.groupService.getCity(id);
	}
	
	@RequestMapping(value="{id}/city",method=RequestMethod.PUT)
	public City putCity(@PathVariable Integer id,@RequestBody City city){
		return this.groupService.putCity(id,city);
	}
	
	@RequestMapping(value="{id}/members",method=RequestMethod.GET)
	public Set<Person> getMembers(@PathVariable Integer id){
		return this.groupService.getMembers(id);
	}
	
	@RequestMapping(value="{id}/members",method=RequestMethod.PUT)
	public Set<Person> putMembers(@PathVariable Integer id,@RequestBody Set<Person> members){
		return this.groupService.putMembers(id,members);
	}
	
	@RequestMapping(value="{id}/members/{person_id}",method=RequestMethod.DELETE)
	public Person deleteMembers(@PathVariable Integer id,@PathVariable Integer person_id){
		return this.groupService.deleteMembers(id,person_id);
	}
}
