package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;

@Service
public class GroupServiceImpl implements GroupService {
	
	private final GroupRepository repo;
	
	private final PersonRepository personRepo;
	
	@Autowired
	public GroupServiceImpl(GroupRepository repo,PersonRepository personrepo) {
		super();
		this.repo = repo;
		this.personRepo = personrepo;
	}
	
	public Group create(Group group){
		return this.repo.save(group);
	}

	@Override
	public List<Group> index() {
		return this.repo.findAll();
	}

	@Override
	public Group read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Group update(Integer id, Group groupToUpdate) {
		groupToUpdate.setId(id);
		return this.repo.save(groupToUpdate);
	}

	@Override
	public Group delete(Integer id) {
		Group group = this.read(id);
		this.repo.delete(id);
		return group;
	}

	@Override
	public Interest getInterest(Integer id) {
		return this.repo.findOne(id).getInterest();
	}

	@Override
	public Interest putInterest(Integer id, Interest interest) {
		Group group = this.repo.findOne(id);
		group.setInterest(interest);
		this.repo.save(group);
		return group.getInterest();
	}

	@Override
	public City getCity(Integer id) {
		return this.repo.findOne(id).getCity();
	}

	@Override
	public City putCity(Integer id, City city) {
		Group group = this.repo.findOne(id);
		group.setCity(city);
		this.repo.save(group);
		return group.getCity();
	}

	@Override
	public Set<Person> getMembers(Integer id) {
		return this.repo.findOne(id).getMembers();
	}

	@Override
	public Set<Person> putMembers(Integer id, Set<Person> members) {
		Group group = this.repo.findOne(id);
		group.setMembers(members);
		this.repo.save(group);
		return group.getMembers();
	}

	@Override
	public Person deleteMembers(Integer id, Integer person_id) {
		Group group = this.repo.findOne(id);
		Person person = this.personRepo.findOne(person_id);
		Set<Person> people = group.getMembers();
		people.remove(person);
		group.setMembers(people);
		this.repo.save(group);
		return person;
	}
}
