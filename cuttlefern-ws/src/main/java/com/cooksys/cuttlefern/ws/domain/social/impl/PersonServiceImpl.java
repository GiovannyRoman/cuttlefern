package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestRepository;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repo;

	private final InterestRepository interestRepo;
	
	private final GroupRepository groupRepo;

	@Autowired
	public PersonServiceImpl(PersonRepository repo, InterestRepository interestrepo,GroupRepository grouprepo) {
		super();
		this.repo = repo;
		this.interestRepo = interestrepo;
		this.groupRepo = grouprepo;
	}

	@Override
	public Person create(Person person) {
		return this.repo.save(person);
	}

	@Override
	public List<Person> index() {
		return this.repo.findAll();
	}

	@Override
	public Person read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Person update(Integer id, Person personToUpdate) {
		personToUpdate.setId(id);
		return this.repo.save(personToUpdate);
	}

	@Override
	public Person delete(Integer id) {
		Person person = this.read(id);
		this.repo.delete(id);
		return person;
	}

	@Override
	public Set<Interest> readInterests(Integer id) {
		return this.repo.findOne(id).getInterests();
	}

	@Override
	public Set<Interest> putInterests(Integer id, Set<Interest> interests) {
		Person person = this.repo.findOne(id);
		person.setInterests(interests);
		this.repo.save(person);
		return person.getInterests();
	}

	@Override
	public Interest deleteInterests(Integer id, Integer interest_id) {
		Person person = this.repo.findOne(id);
		Interest interest = this.interestRepo.findOne(interest_id);
		Set<Interest> interests = person.getInterests();
		interests.remove(interest);
		person.setInterests(interests);
		this.repo.save(person);
		return interest;
	}

	@Override
	public Set<Group> readGroups(Integer id) {
		return this.repo.findOne(id).getGroups();
	}

	@Override
	public Set<Group> putGroups(Integer id, Set<Group> groups) {
		Person person = this.repo.findOne(id);
		person.setGroups(groups);
		this.repo.save(person);
		return person.getGroups();
	}

	@Override
	public Group deleteGroups(Integer id, Integer group_id) {
		Person person = this.repo.findOne(id);
		Group group = this.groupRepo.findOne(group_id);
		Set<Group> groups = person.getGroups();
		groups.remove(group);
		person.setGroups(groups);
		return group;
	}

}
